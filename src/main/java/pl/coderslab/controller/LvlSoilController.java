package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Digging;
import pl.coderslab.model.LvlSoil;
import pl.coderslab.model.Soil;
import pl.coderslab.service.DiggingService;
import pl.coderslab.service.LvlSoilService;
import pl.coderslab.service.SoilService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/lvlSoil")
public class LvlSoilController {

    private final LvlSoilService lvlSoilService;
    private final SoilService soilService;
    private final DiggingService diggingService;

    public LvlSoilController(LvlSoilService lvlSoilService, SoilService soilService, DiggingService diggingService) {
        this.lvlSoilService = lvlSoilService;
        this.soilService = soilService;
        this.diggingService = diggingService;
    }

    @ModelAttribute("soilList")
    public List<Soil> showAllSoil(){
        return soilService.getAll();
    }

    @ModelAttribute("allById")
            public List<LvlSoil> showById(@PathVariable Long idDigging){
      return lvlSoilService.allLvlSoilByIdDigging(idDigging);

    }

    @RequestMapping("/{idDigging}")
    private String addLvl(@PathVariable Long idDigging, Model model){
        LvlSoil lvlSoil = new LvlSoil();
        model.addAttribute("lvlSoil", lvlSoil);
        return "addLvlSoil";
    }

    @PostMapping("/{idDigging}")
    private String addLvl(@PathVariable Long idDigging, @Valid LvlSoil lvlSoil, BindingResult result){
        if(result.hasErrors()){
            return "addLvlSoil";
        }
        Digging digging = diggingService.get(idDigging).orElseThrow();
        lvlSoil.setDigging(digging);
        lvlSoilService.add(lvlSoil);
        return "redirect:/lvlSoil/list/{idDigging}";
    }

    @RequestMapping("/list/{idDigging}")
    public String list(@PathVariable Long idDigging, Model model){
        model.addAttribute("id", idDigging);
        return "listLvlSoil";
    }

    @RequestMapping("/end/{idDigging}")
    public String endDigging(@PathVariable Long idDigging){
        Digging digging = diggingService.get(idDigging).get();
        digging.setEndDigging(LocalDateTime.now());
        diggingService.add(digging);
        return "redirect:/digging/reports";
    }


}
