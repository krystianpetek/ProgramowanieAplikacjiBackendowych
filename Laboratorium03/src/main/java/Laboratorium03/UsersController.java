package Laboratorium03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class UsersController {
    private final ArrayList<UserEntityDTO> users = new ArrayList<>();
    private Integer count = 0;

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

        ArrayList<UserEntityDTO> usersPage = new ArrayList<>();

        int start = CalcPagination(pageNumber-1, pageSize);
        int stop = CalcPagination(pageNumber, pageSize);

        for(int i = start;i<stop;i++)
        {
            if(users.size() == 0)
                break;
            if(i == users.size())
                break;
            usersPage.add( users.get(i));
        }
        return new UsersApi(pageNumber, (int)pagesCount, pageSize, users.size(), usersPage);
    }

    @GetMapping("api/users/{id}/get")
    @ResponseBody
    public Object getUser(@PathVariable Integer id) {
        if(users.size()== 0)
         return "Nie znaleziono użytkownika";

        var user = users.get(--id);
        return user;
    }

//    http://localhost:8080/api/user/add?imie=Krystian&nazwisko=Petek&email=krystianpetek@gmail.com
//    http://localhost:8080/api/user/add?imie=Teresa&nazwisko=Petek&email=teresapetek@gmail.com
//    http://localhost:8080/api/user/add?imie=Józef&nazwisko=Petek&email=jozefpetek@gmail.com
//    http://localhost:8080/api/user/add?imie=Patrycja&nazwisko=Petek&email=patrycjapetek@gmail.com
//    http://localhost:8080/api/user/add?imie=Gabriel&nazwisko=Warchał&email=gabrielwarchal@gmail.com
//    http://localhost:8080/api/user/add?imie=Janina&nazwisko=Warchał&email=janinawarchal@gmail.com
//    http://localhost:8080/api/user/add?imie=Agnieszka&nazwisko=Warchał&email=agnieszkawarchal@gmail.com
//    http://localhost:8080/api/user/add?imie=Krystian&nazwisko=Porębski&email=krystianporebski@gmail.com
//    http://localhost:8080/api/user/add?imie=Lena&nazwisko=Porębska&email=lenaporebska@gmail.com
//    http://localhost:8080/api/user/add?imie=Grzegorz&nazwisko=Warchał&email=grzegorzwarchal@gmail.com
    @GetMapping("/api/user/add")
    @ResponseBody
    public boolean addUser(
            @RequestParam String imie,
            @RequestParam String nazwisko,
            @RequestParam String email
            ) {

        UserEntityDTO uzytkownik = new UserEntityDTO(++count, imie + " "+ nazwisko, email);
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

    private static int CalcPagination(int pageNumber, int pageSize)
    {
        return pageSize * pageNumber;
    }

}
