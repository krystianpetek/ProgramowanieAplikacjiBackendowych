package Laboratorium04.Service;

import org.springframework.stereotype.Service;

public class UserEntityService {

    public int id;
    public String name;
    public String email;

    public UserEntityService(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public UserEntityService(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
