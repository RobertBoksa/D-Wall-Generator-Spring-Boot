package pl.coderslab.controller;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Cage;
import pl.coderslab.model.Section;
import pl.coderslab.service.CageService;
import pl.coderslab.service.SectionService;

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


    @ModelAttribute("cagesList")
    public List<Cage> cageList(){
        List<Cage> cageList = cageService.getAll();
       return  cageList;
    }

    @RequestMapping("/")
    public String showAllSections(Model model){


        return "sectionList";
    }

    @GetMapping ("/add")
    public String addSection(Model model, Long id){
        Section section = new Section();
        model.addAttribute("section", section);
        return "addSection";
    }

    @PostMapping("/add")
    public String addSection(Section section){
        sectionService.add(section);
        return "addSection";
    }
}
