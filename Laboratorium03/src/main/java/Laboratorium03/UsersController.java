package Laboratorium03;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class UsersController {

    @RequestMapping("/")
    @ResponseBody
    public Object index() {
        return "Hello World!";
    }

    private ArrayList<UserEntityDTO> users = new ArrayList<>();
    private Integer count = 1;

    @GetMapping("api/users")
    @ResponseBody
    public Object getUsers(
            @RequestParam(defaultValue = "1", required = false, name = "page-number") Integer pageNumber,
            @RequestParam(defaultValue = "20", required = false, name = "page-size") Integer pageSize
    ) {
        if(pageNumber < 1)
            pageNumber = 1;

        if(pageSize < 1)
            pageSize = 1;

        if(pageSize > 100)
            pageSize = 100;

        double pagesCount;
        if(users.size() <= pageSize)
            pagesCount = 1;
        else
         pagesCount = Math.ceil(users.size()/ pageSize);

        ArrayList<UserEntityDTO> usersPage = new ArrayList<UserEntityDTO>();

        int start = CalcPagination(pageNumber, pageSize);

        for(int i = start;i<pageSize;i++)
        {
            if(users.get(i) == null)
                break;
            usersPage.add( users.get(i));
        }
        return new UsersApi(pageNumber, (int)pagesCount, pageSize, users.size(), usersPage);
    }

    private static int CalcPagination(int pageNumber, int pageSize)
    {
        return ((pageNumber*pageSize)-pageSize);
    }

    @GetMapping("api/users/{id}/get")
    @ResponseBody
    public Object getUser(@PathVariable Integer id) {
        var user = users.get(id);
        if (user != null) {
            return user;
        }
        return "Nie znaleziono użytkownika";
    }
//    http://localhost:8080/api/user/add?imie=Krystian&nazwisko=Petek&email=krystianpetek@gmail.com&wiek=23
//    http://localhost:8080/api/user/add?imie=Teresa&nazwisko=Petek&email=teresapetek@gmail.com&wiek=52
//    http://localhost:8080/api/user/add?imie=Józef&nazwisko=Petek&email=jozefpetek@gmail.com&wiek=50
//    http://localhost:8080/api/user/add?imie=Patrycja&nazwisko=Petek&email=patrycjapetek@gmail.com&wiek=25
//    http://localhost:8080/api/user/add?imie=Gabriel&nazwisko=Warchał&email=gabrielwarchal@gmail.com&wiek=29
//    http://localhost:8080/api/user/add?imie=Janina&nazwisko=Warchał&email=janinawarchal@gmail.com&wiek=59
//    http://localhost:8080/api/user/add?imie=Agnieszka&nazwisko=Warchał&email=agnieszkawarchal@gmail.com&wiek=35
//    http://localhost:8080/api/user/add?imie=Krystian&nazwisko=Porębski&email=krystianporebski@gmail.com&wiek=35
//    http://localhost:8080/api/user/add?imie=Lena&nazwisko=Porębska&email=lenaporebska@gmail.com&wiek=4
//    http://localhost:8080/api/user/add?imie=Grzegorz&nazwisko=Warchał&email=grzegorzwarchal@gmail.com&wiek=41

    @GetMapping("/api/user/add")
    @ResponseBody
    public boolean addUser(
            @RequestParam String imie,
            @RequestParam String nazwisko,
            @RequestParam String email,
            @RequestParam Integer wiek
            ) {

        UserEntityDTO uzytkownik = new UserEntityDTO(count++, imie + " "+ nazwisko, email);
        users.add(uzytkownik);
        return true;
    }

    @GetMapping("api/users/{id}/remove")
    @ResponseBody
    public boolean removeUser(@PathVariable Integer id) {
        if(users.get(id) == null)
            return false;

        users.remove(id);
            return true;

    }
}
