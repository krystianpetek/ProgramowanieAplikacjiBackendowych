package Konwersatorium02.Service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class UsersService {

    private PermissionService permissionService;
    // UsersService ma tą samą instancje PermissionService co inne klasy

    public String getUsers() {
        this.permissionService.checkPermission("root");
        return "john,matt,chris";
    }
    // service może używać innego service

    // events handling: create / destroy events /// działa z @Controller a także z @Service
    // czas życia, static scope, żyje tak dlugo, jak działa aplikacja
    @PostConstruct
    private void onCreate(){
        System.out.println("UsersService: onCreate");
    }
    @PreDestroy
    private void onDestroy(){
        System.out.println("UsersService: onDestroy");
    }
}
