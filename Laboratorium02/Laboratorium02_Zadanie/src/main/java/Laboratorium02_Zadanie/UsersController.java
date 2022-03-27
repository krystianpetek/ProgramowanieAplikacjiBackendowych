package Laboratorium02_Zadanie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UsersController {
    private Map<Integer, UserEntity> users = new HashMap<>();

    @RequestMapping("/users")
    @ResponseBody
    public String getUsers()
    {
        StringBuilder sb = new StringBuilder();
        for(UserEntity val : users.values()){
            sb.append(val.toString());
        }
        return sb.toString();
    }

    @GetMapping("/users/{id}/get")
    @ResponseBody
    public String getUser(Integer id)
    {
        for (Integer key : users.keySet())
        {
            if(users.containsKey(id))
                return users.get(id).toString();
        }
        return "Nie znaleziono użytkownika";
    }

    // http://localhost:8080/user/add?firstName=Krystian&lastName=Petek&age=23
    @RequestMapping("/user/add?firstName=param1&lastName=param2&age=param3")
    @ResponseBody
    public boolean addUser(
            @RequestParam String param1,
            @RequestParam String param2,
            @RequestParam Integer param3)
    {
        UserEntity uzytkownik = new UserEntity(param1, param2, param3);
        if(uzytkownik.getFirstName() != null && uzytkownik.getLastName() != null && uzytkownik.getAge() != 0)
        {
            users.put(1,uzytkownik);
            return true;
        }
        return false;
    }


}
