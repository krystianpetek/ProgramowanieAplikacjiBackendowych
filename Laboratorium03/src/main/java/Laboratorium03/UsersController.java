package Laboratorium03;

import Laboratorium03.Service.StringResponseService;
import Laboratorium03.Service.UserEntityService;
import Laboratorium03.Service.UsersApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class UsersController {

    private Map<Integer, UserEntityService> usersSet = new TreeMap();
    private Integer count = 0;

    private static int CalcPagination(int pageNumber, int pageSize) {
        return ( pageSize * pageNumber)+1;
    }

    @GetMapping("api/users")
    @ResponseBody
    public Object getUsers(
            @RequestParam(defaultValue = "1", required = false, name = "page-number") Integer pageNumber,
            @RequestParam(defaultValue = "20", required = false, name = "page-size") Integer pageSize
    ) {
        int sizeSet = usersSet.size();

        if(pageNumber < 1)
            pageNumber = 1;

        if(pageSize < 1)
            pageSize = 1;

        if(pageSize > 100)
            pageSize = 100;

        double pagesCount;
        if(sizeSet <= pageSize)
            pagesCount = 1;
        else
            pagesCount = Math.ceil(sizeSet / pageSize);

        ArrayList<UserEntityService> usersPage = new ArrayList<>();

        int start = CalcPagination(pageNumber-1, pageSize);
        int stop = CalcPagination(pageNumber, pageSize);

        for(int i = start;i<stop;i++) {
            if (sizeSet == 0)
                break;
            if(usersSet.get(i) == null)
                continue;
            usersPage.add(usersSet.get(i));
        }
        return new UsersApiService(pageNumber, (int) pagesCount, pageSize, sizeSet, usersPage);
    }

    @RequestMapping(value = "/api/users/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserEntityService addUser(
            @RequestBody UserEntityService user
    ) {

        UserEntityService uzytkownik = new UserEntityService(++count, user.name, user.email);
        usersSet.put(count,uzytkownik);
        return uzytkownik;
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserEntityService> getUser(@PathVariable Integer id) {
        UserEntityService user = null;
        try{
            user = usersSet.get(id);
        }
        catch(IndexOutOfBoundsException e) {}

        if(user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(user);
    }

    @RequestMapping(value = "/api/users/{id}/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserEntityService> updateUser(
            @PathVariable Integer id,
            @RequestBody UserEntityService user
    ) {
        UserEntityService tempUser = usersSet.get(id);
        if(tempUser == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        tempUser.name = user.name;
        tempUser.email = user.email;
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(tempUser);
    }

    @RequestMapping(value = "/api/users/{id}/remove", method = RequestMethod.GET)
    @ResponseBody
    public Object removeUser(@PathVariable Integer id) {

        Boolean response = false;

            var eks= usersSet.get(id);
            if (eks != null) {
                usersSet.remove(id);
                response = true;
            }

        return new StringResponseService(response);
    }



}
