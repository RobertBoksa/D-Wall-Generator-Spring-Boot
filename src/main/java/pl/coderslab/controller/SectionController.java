package pl.coderslab.controller;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.model.Cage;
import pl.coderslab.model.Section;
import pl.coderslab.service.CageService;
import pl.coderslab.service.SectionService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("admin/section")
public class SectionController {

    private final SectionService sectionService;
    private final CageService cageService;

    public SectionController(SectionService sectionService, CageService cageService) {
        this.sectionService = sectionService;
        this.cageService = cageService;
    }


    @ModelAttribute("cageLists")
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
    public String addSection(Model model){
        Section section = new Section();
        model.addAttribute("section", section);
        return "addSection";
    }

    @PostMapping("/add")
    public String addSection(@Valid Section section, BindingResult result){
       if(result.hasErrors()){
           return "addSection";
       }
        sectionService.add(section);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/update")
    public String updateSection(Long id, Model model){
       Section section = sectionService.get(id).orElseThrow();
       model.addAttribute("section", section);
       return "addSection";
    }

    @PostMapping("/update")
    public String update(Section section){
        sectionService.update(section);
        return "redirect:/admin/section/";
    }

    @GetMapping("/close/{id}")
    public String closeSection(@PathVariable Long id){
        Section section = sectionService.get(id).orElseThrow();
        section.setStatus(2);
        sectionService.update(section);
        return "redirect:/admin/section/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteSection(@PathVariable Long id, Model model){
        Section section = sectionService.get(id).orElseThrow();
        model.addAttribute("section", section);
        return "acceptDelSection";
    }

    @RequestMapping ("/deleteAccepted")
    public String deleteSection(@RequestParam Long id){
        sectionService.delete(id);
        return "redirect:/admin/section/";
    }


}
