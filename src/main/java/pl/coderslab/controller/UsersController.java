package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.service.UsersService;

@Controller
public class UsersController {

    private final UsersService personService;

    public UsersController(UsersService personService) {
        this.personService = personService;
    }

    @RequestMapping("/")
    public String showDashboard(){
        return "dashboard";
    }

    @RequestMapping("/403")
    public String accessDenied(){
        return "accessDenied";
    }
}
