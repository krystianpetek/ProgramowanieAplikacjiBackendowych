package Laboratorium02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("api/products")
    @ResponseBody
    public Object apiUsers() {
        List<ProductEntity> products = new ArrayList<>();
        products.add(new ProductEntity(1, "Produkt 1"));
        products.add(new ProductEntity(2, "Produkt 2"));
        products.add(new ProductEntity(3, "Produkt 3"));
        return products;
    }

    // http://localhost:1000/api/products/ - zwraca dane w postaci JSON z Listy products
}