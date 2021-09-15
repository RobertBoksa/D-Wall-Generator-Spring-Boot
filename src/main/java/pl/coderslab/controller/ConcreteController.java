package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Concrete;
import pl.coderslab.model.Section;
import pl.coderslab.service.ConcreteService;
import pl.coderslab.service.SectionService;

import java.util.List;

@Controller
@RequestMapping("/admin/concrete")
public class ConcreteController {

    private final ConcreteService concreteService;
    private final SectionService sectionService;

    public ConcreteController(ConcreteService concreteService, SectionService sectionService) {
        this.concreteService = concreteService;
        this.sectionService = sectionService;
    }

    @ModelAttribute("sections")
    public List<Section> showAllSection(){
        return sectionService.sectionsNotEnd(1);
    }


    @GetMapping("/")
    public String addConcrete(Model model){
        Concrete concrete = new Concrete();
        model.addAttribute("concrete", concrete);
        return "addConcrete";
    }

    @PostMapping("/")
    public String addConcrete(Concrete concrete){
        concreteService.add(concrete);
        return "addConcrete";
    }

}
