package Konwersatorium02;

import org.springframework.stereotype.Service;

@Service
public class UsersService {
    public String getUsers() {
        return "john,matt,chris";
    }
}
