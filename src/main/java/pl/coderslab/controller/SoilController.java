package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Soil;
import pl.coderslab.service.SoilService;

@Controller
@RequestMapping("/soil")
public class SoilController {

    private final SoilService soilService;

    public SoilController(SoilService soilService) {
        this.soilService = soilService;
    }

    @GetMapping("/add")
    public String addSoil(Model model){
        Soil soil = new Soil();
        model.addAttribute("soil", soil);
        return "addSoil";
    }

    @PostMapping("/add")
    public String addSoil(Soil soil){
        soilService.add(soil);
        return "redirect:/soil/add";
    }
}
