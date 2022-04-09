package Laboratorium02_Zadanie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UsersController {
    private final Map<Integer, UserEntity> users = new HashMap<>();
    private Integer licznik = 1;

    @GetMapping("/users")
    @ResponseBody
    public Object getUsers() {
        return users.values();
    }

    @GetMapping("/users/{id}/get")
    @ResponseBody
    public Object getUser(@PathVariable Integer id) {
        var user = users.get(id);
        if (user != null) {
            return user;
        }
        return "Nie znaleziono użytkownika";
    }

    // http://localhost:8080/user/add?imie=Krystian&nazwisko=Petek&wiek=23
    @GetMapping("/user/add")
    @ResponseBody
    public boolean addUser(
            @RequestParam String imie,
            @RequestParam String nazwisko,
            @RequestParam Integer wiek) {
        UserEntity uzytkownik = new UserEntity(imie, nazwisko, wiek);
        users.put(licznik++, uzytkownik);
        return true;
    }

    @GetMapping("/users/{id}/remove")
    @ResponseBody
    public boolean removeUser(@PathVariable Integer id) {
        if (users.containsKey(id)) {
            users.remove(id);
            return true;
        }
        return false;
    }

}
