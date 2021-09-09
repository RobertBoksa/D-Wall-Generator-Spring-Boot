package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.service.PersonService;

@Controller
@RequestMapping("/admin")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/dashboard")
    public String showDashboard(){
        return "dashboard";
    }


}
