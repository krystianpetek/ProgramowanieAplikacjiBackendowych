package Konwersatorium02.Controllers;

import Konwersatorium02.PermissionService;
import Konwersatorium02.UserEntity;
import Konwersatorium02.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {

    @Autowired
    private UsersService userService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/users")
    public String users() {
        return "users";
    }

    // http://localhost:8080/api/users?pageNumber=3&usersAmount=20
    @RequestMapping("/api/users/")
    @ResponseBody
    public String getApiUsers(
            @RequestParam(defaultValue = "1") Integer pageNumber,
            @RequestParam(required = false) Integer usersAmount
    ) {
        this.permissionService.checkPermission("root");
        return pageNumber + " " + usersAmount + " " + this.userService.getUsers();
    }

    @RequestMapping("/api/users/{id}")
    @ResponseBody
    public String getApiUsers(
            @PathVariable Long id,
            @RequestParam(required = false) Boolean details
    ) {
        return "UserID = " + id + " (details: " + details + ")";
    }

    @RequestMapping("/api/users2/{id}")
    @ResponseBody
    public Object getApiUsers(
            @PathVariable Long id
    ) {
        return new UserEntity(id);
    }
}
