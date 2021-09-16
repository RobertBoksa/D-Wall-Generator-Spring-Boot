package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Digging;
import pl.coderslab.model.Section;
import pl.coderslab.service.DiggingService;
import pl.coderslab.service.SectionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/digging")
public class DiggingController {

  private final DiggingService diggingService;
  private final SectionService sectionService;

    public DiggingController(DiggingService diggingService,
                             SectionService sectionService) {
        this.diggingService = diggingService;
        this.sectionService = sectionService;
    }


    @ModelAttribute("sections")
    public List<Section> showAllSection(){
       return sectionService.sectionsNotEnd(1);
    }

    @ModelAttribute("allSections")
    public List<Section> allSection(){
        return sectionService.getAll();
    }

    @GetMapping("/")
    public String startDigging(Model model){
        Digging digging = new Digging();
        model.addAttribute("digging", digging);
        return "choseDiggingSection";
    }

    @PostMapping("/")
    public String startDigging(@Valid Digging digging, BindingResult result){
        if(result.hasErrors()){
            return "choseDiggingSection";
        }
        Digging diggingReturned = diggingService.addAndFlash(digging);
       Long idSec = diggingReturned.getSectionDigg().getId();
       Long idDig = diggingReturned.getId();
       sectionService.updateStartTime(idSec);
        return "redirect:/lvlSoil/"+idDig;
    }

    @RequestMapping("/reports")
    public String diggingReports(){
        return "diggingList";
    }
}
