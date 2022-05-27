package Laboratorium04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AuthenticationService {

    @Value("${admin.username}")
    private String adminUsername;
    @Value("${admin.password}")
    private String adminPassword;

    public boolean checkUser(HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession();
        Long loggedUserId = (Long) httpSession.getAttribute("logged-user-id");
        if(loggedUserId != null)
        {
            return true;
        }
        return false;
    }

    public boolean loginUser(HttpServletRequest httpServletRequest, @RequestBody UserLoginRequest userLoginRequest) {

        HttpSession httpSession = httpServletRequest.getSession();
        Long loggedUserId = (Long) httpSession.getAttribute("logged-user-id");
        if (loggedUserId != null) {
            return "Error: Jesteś już zalogowany!";
        }
        // TODO - zapytanie do bazy aby sprawdzić dostępnego użytkwnika i pobrać jego ip
        if (adminUsername.equals(userLoginRequest.getIdentifier()) && adminPassword.equals(userLoginRequest.getPassword()))
        {
            httpSession.setAttribute("logged-user-id", 1000L);
            return "Zalogowany!";
        }
        return "Error: błąd logowania";
    }

}
