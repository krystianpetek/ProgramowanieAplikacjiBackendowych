package Laboratorium03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UsersController {

    @RequestMapping("/")
    @ResponseBody
    public Object index() {
        return "Hello World!";
    }

    private final Map<Integer, UserEntity> users = new HashMap<>();
    private Integer licznik = 1;

    @GetMapping("api/users")
    @ResponseBody
    public Object getUsers(
            @RequestParam(defaultValue = "1", required = false, name = "page-number") Integer pageNumber,
            @RequestParam(defaultValue = "20", required = false, name = "page-size") Integer pageSize
    ) {
        Collection<UserEntityDTO> usersDTO =
        for(int i = 0;i<users.size();i++)
        {
            var user = users.get(i);
            usersDTO.add(i,new UserEntityDTO(i,user.firstName + user.lastName, user.email));
        }
        
        if(pageNumber < 1)
            pageNumber = 1;

        if(pageSize < 1)
            pageSize = 1;

        if(pageSize > 100)
            pageSize = 100;

        int pagesCount = 1;
        if(users.size() > 0)
            pagesCount = (int)Math.ceil(users.size() / pageSize);

        return new UsersApi(pageNumber, pagesCount, pageSize, users.size(),usersDTO);
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
//
//    http://localhost:8080/user/add?imie=Krystian&nazwisko=Petek&wiek=23&krystianpetek@gmail.com
//    http://localhost:8080/user/add?imie=Teresa&nazwisko=Petek&wiek=52&teresapetek@gmail.com
//    http://localhost:8080/user/add?imie=Józef&nazwisko=Petek&wiek=50&jozefpetek@gmail.com
//    http://localhost:8080/user/add?imie=Patrycja&nazwisko=Petek&wiek=25&patrycjapetek@gmail.com
//    http://localhost:8080/user/add?imie=Gabriel&nazwisko=Warchał&wiek=29&gabrielwarchal@gmail.com
//    http://localhost:8080/user/add?imie=Janina&nazwisko=Warchał&wiek=59&janinawarchal@gmail.com
//    http://localhost:8080/user/add?imie=Agnieszka&nazwisko=Warchał&wiek=35&agnieszkawarchal@gmail.com
//    http://localhost:8080/user/add?imie=Krystian&nazwisko=Porębski&wiek=35&krystianporebski@gmail.com
//    http://localhost:8080/user/add?imie=Lena&nazwisko=Porębska&wiek=4&lenaporebska@gmail.com
//    http://localhost:8080/user/add?imie=Grzegorz&nazwisko=Warchał&wiek=41&grzegorzwarchal@gmail.com
    @GetMapping("/user/add")
    @ResponseBody
    public boolean addUser(
            @RequestParam String imie,
            @RequestParam String nazwisko,
            @RequestParam Integer wiek,
            @RequestParam String email) {
        UserEntity uzytkownik = new UserEntity(imie, nazwisko, wiek,email);
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
