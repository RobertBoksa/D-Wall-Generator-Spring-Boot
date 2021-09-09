package pl.coderslab.controller;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Cage;
import pl.coderslab.model.Section;
import pl.coderslab.service.CageService;


@Setter
@Getter
@EqualsAndHashCode
@Controller
@RequestMapping("/admin/cage")
public class CageController {

    private final CageService cageService;

    public CageController(CageService cageService) {
        this.cageService = cageService;
    }

    @RequestMapping("/")
    public String showAllCages(Model model){
        return "cagesList";
    }

    @GetMapping("/add")
    public String addCage(Model model, Long id){
        Cage cage = new Cage();
        model.addAttribute("cage", cage);
        return "addCage";
    }

    @PostMapping("/add")
    public String addCage(Cage cage){
        cageService.add(cage);
        return "addCage";
    }


}
