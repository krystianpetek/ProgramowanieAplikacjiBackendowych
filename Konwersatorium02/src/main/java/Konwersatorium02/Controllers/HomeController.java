package Konwersatorium02.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

//    @RequestMapping("/")
//    @ResponseBody
//    public String index() {
//        return "Hello World!";
//    }

    @RequestMapping("/")
    public String template() {
        return "template";
    }
}