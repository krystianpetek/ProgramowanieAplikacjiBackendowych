package Laboratorium02_Zadanie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "Hello World!";
    }

    @RequestMapping("/example")
    public String users() {
        return "szablon"; // resources/templates/szablon.html
    }
}