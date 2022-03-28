package Konwersatorium02.Service;

import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private PermissionService permissionService;
    // UsersService ma tą samą instancje PermissionService co inne klasy

    public String getUsers() {
        this.permissionService.checkPermission("root");
        return "john,matt,chris";
    }
    // service może używać innego service
}
