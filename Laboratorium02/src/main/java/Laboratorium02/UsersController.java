package Laboratorium02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {

    // dodajemy templates
    // resources/templates/example.html

    // http://localhost:1000/users/
    @RequestMapping("/users")
    public String users() {
        return "example"; // example.html - sciezka do pliku resources/templates/example.html
    }

    @RequestMapping("/users2")
    public String users2() {
        return "example2"; // example.html - sciezka do pliku resources/templates/example.html
    }

    // dodajemy dependencies do pom.xml
    //      <dependency>
    //			<groupId>org.springframework.boot</groupId>
    //			<artifactId>spring-boot-starter-thymeleaf</artifactId>
    //		</dependency>

    //a by wyswietlic szablon przechodzimy do http://localhost:1000/users/


}