package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Section;
import pl.coderslab.model.Soil;
import pl.coderslab.service.ReportService;
import pl.coderslab.service.SectionService;
import pl.coderslab.service.SoilService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class ReportController {

    private final SectionService sectionService;
    private final SoilService soilService;
    private final ReportService reportService;

    public ReportController(SectionService sectionService, SoilService soilService, ReportService reportService) {
        this.sectionService = sectionService;
        this.soilService = soilService;
        this.reportService = reportService;
    }

    @ModelAttribute("soilList")
    private List<Soil> showAllSoil(){
        return soilService.getAll();
    }



    @RequestMapping("/report/{id}")
    public String oneReport(@PathVariable(required = false) Long id, Model model){
        Section section = sectionService.get(id).get();
        model.addAttribute("section", section);
        Double max = reportService.maxDepthDigg(id);
        model.addAttribute("maxDepth", max);
        Map<Long, List<String>> lvlList = reportService.getListSoil(id);
        model.addAttribute("map", lvlList);
        Long countConcrete = reportService.countConcrete(id);
        model.addAttribute("conCount", countConcrete);
        return "showReport";
    }
}
