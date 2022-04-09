package Laboratorium02_Zadanie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/example")
    public String users() {
        return "szablon"; // resources/templates/szablon.html
    }
}