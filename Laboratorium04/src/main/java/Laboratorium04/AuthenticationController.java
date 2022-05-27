package Laboratorium04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/api/user/check", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String checkUser(HttpServletRequest httpServletRequest) {
        if(this.authenticationService.checkUser(httpServletRequest))
        {
            return "Zalogowany!";
        }
        return "Nie zalogowany!";
    }

    @RequestMapping(value = "/api/user/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String loginUser(HttpServletRequest httpServletRequest, @RequestBody UserLoginRequest userLoginRequest) {


        if(this.authenticationService.checkUser(httpServletRequest))
            return "Error: Jesteś już zalogowany!";

        // TODO - zapytanie do bazy aby sprawdzić dostępnego użytkwnika i pobrać jego ip

        if(this.authenticationService.loginUser(httpServletRequest,userLoginRequest))
        {
            httpSession.setAttribute("logged-user-id", 1000L)
        }

        return "Error: błąd logowania";
    }
}
