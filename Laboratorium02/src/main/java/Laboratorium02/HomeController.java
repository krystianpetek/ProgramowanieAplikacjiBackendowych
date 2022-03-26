package Laboratorium02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("/example2")
    @ResponseBody
    public String example2() {
        return "example2 message!";
    }

    // http://localhost:8080/example2/Krystian/23?parameter2=true&parameter1=Koziniec_2
    @RequestMapping("/example2/{name}/{age}")
    @ResponseBody
    public String example2(
            @PathVariable String name,
            @PathVariable Integer age,
            @RequestParam(required = false) String parameter1,
            @RequestParam(required = false) String parameter2) {
        return "example2 message! " +
                name + " " +
                age + "\n" +
                parameter1 + " " +
                parameter2 + "\n";

    }
}