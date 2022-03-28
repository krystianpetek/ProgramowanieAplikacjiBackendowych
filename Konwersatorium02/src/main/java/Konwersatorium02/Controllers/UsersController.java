package Konwersatorium02.Controllers;

import Konwersatorium02.Config.Item;
import Konwersatorium02.Config.Store;
import Konwersatorium02.Service.PermissionService;
import Konwersatorium02.Service.UsersService;
import Konwersatorium02.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private PermissionService permissionService;

    // 1 sposób na dodawanie/odwoływanie Bean'ów
    @Autowired
    private Item item;
    @Autowired
    private Store store;

    @RequestMapping("/users")
    public String users() {
        return "users";
    }

    // http://localhost:8080/api/users?pageNumber=3&usersAmount=20
    @RequestMapping("/api/users")
    @ResponseBody
    public String getApiUsers(
            @RequestParam(defaultValue = "1") Integer pageNumber,
            @RequestParam(required = false) Integer usersAmount
    ) {
        this.permissionService.checkPermission("root");
        return pageNumber + " " + usersAmount + " " + this.usersService.getUsers();
    }

    @RequestMapping("/api/users/{id}")
    @ResponseBody
    public String getApiUsersId(
            @PathVariable Long id,
            @RequestParam(required = false) Boolean details
    ) {
        return "UserID = " + id + " (details: " + details + ")";
    }

    @RequestMapping("/api/users2/{id}")
    @ResponseBody
    public Object getApiUsersId2(
            @PathVariable Long id
    ) {
        return new UserEntity(id, "John");
    }


    @RequestMapping("/api/users2")
    @ResponseBody
    public Object getApiUsers2(
            @RequestParam(defaultValue = "1") Integer pageNumber,
            @RequestParam(required = false) Integer usersAmount
    ) {
        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity(1L, "Text 1"));
        users.add(new UserEntity(2L, "Text 2"));
        users.add(new UserEntity(3L, "Text 3"));
        return users;
    }

    // events handling: create / destroy events /// działa z @Controller a także z @Service
    @PostConstruct
    private void onCreate(){
        System.out.println("UsersController: onCreate");
    }
    @PreDestroy
    private void onDestroy(){
        System.out.println("UsersController: onDestroy");
    }
}
