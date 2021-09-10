package pl.coderslab.controller;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.model.Cage;
import pl.coderslab.model.Section;
import pl.coderslab.service.CageService;
import pl.coderslab.service.SectionService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Controller
@RequestMapping("admin/section")
public class SectionController {

    private final SectionService sectionService;
    private final CageService cageService;

    public SectionController(SectionService sectionService, CageService cageService) {
        this.sectionService = sectionService;
        this.cageService = cageService;
    }


    @ModelAttribute("cageList")
    public List<Cage> cageList(){
       return cageService.getAll();
    }



    @RequestMapping("/")
    public String showAllSections(Model model){
        List<Section> sections = sectionService.getAll();

        model.addAttribute("allSec", sections);
        return "sectionList";
    }

    @GetMapping ("/add")
    public String addSection(Model model, Long id){
        Section section;
        if(id != null){
            section = sectionService.get(id).get();
        } else {
            section = new Section();
        }
        model.addAttribute("section", section);
        return "addSection";
    }

    @PostMapping("/add")
    public String addSection(Section section){
//        Section sectionNew = section;
//        List<Cage> cages = new ArrayList<>();
//        Cage cage1 = cageService.get(Long.parseLong(cageList)).get();
//        cages.add(cage1);
//        sectionNew.setCageList((List<Cage>) cage1);
        sectionService.add(section);
        return "redirect:/admin/dashboard";
    }


}
