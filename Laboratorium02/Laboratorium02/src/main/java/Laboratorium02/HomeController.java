package Laboratorium02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    // coretto-11 sdk

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
    // spring boot application.properties
    // server.port=1000
    // http://localhost:1000/example2/Krystian/23?parameter2=true&parameter1=Koziniec_2

    // dodawanie plikow statycznych
    // resources => static => umieszczamy pliki, np. plik.txt
    // aby sie odwołać do pliku to przechodzimy do adresu http://localhost:1000/plik.txt
    // lub np. imgs/zdjecie.png http://localhost:1000/imgs/R.png
}