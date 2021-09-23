package pl.coderslab.controller;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Cage;
import pl.coderslab.model.Section;
import pl.coderslab.service.CageService;

import javax.validation.Valid;
import java.util.List;


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
        List<Cage> cages = cageService.getAll();
        model.addAttribute("allCag", cages);
        return "cageList";
    }


    @GetMapping("/add")
    public String addCage(Model model){
        Cage cage = new Cage();
        model.addAttribute("cage", cage);
        return "addCage";
    }

    @PostMapping("/add")
    public String addCage(@Valid Cage cage, BindingResult result){
        if(result.hasErrors()){
            return "addCage";
        }
        cageService.add(cage);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateCage(Long id, Model model){
        Cage cage = cageService.get(id).orElseThrow();
        model.addAttribute("cage", cage);
        return "addCage";
    }

    @PostMapping("/update")
    public String updateCage(@Valid Cage cage, BindingResult result){
        if(result.hasErrors()){
            return "addCage";
        }
        cageService.update(cage);
        return "redirect:/admin/cage/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCage(@PathVariable Long id, Model model){
        Cage cage = cageService.get(id).orElseThrow();
        model.addAttribute("cage", cage);
        return "acceptDelCage";
    }

    @RequestMapping ("/deleteAccepted")
    public String deleteSection(@RequestParam Long id){
        cageService.delete(id);
        return "redirect:/admin/cage/";
    }



}
