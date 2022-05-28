package Laboratorium05;

import Laboratorium05.request.UserLoginRequest;
import Laboratorium05.request.UserRegisterRequest;
import Laboratorium05.response.UserActionResponse;
import Laboratorium05.response.UserCheckResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/api/user/check")
    public ResponseEntity<UserCheckResponse> checkUser(HttpServletRequest request)
    {
        return ResponseEntity.ok(this.authenticationService.checkUser(request));
    }

    @PostMapping("/api/user/login")
    public ResponseEntity<UserActionResponse> loginUser(HttpServletRequest request, @RequestBody UserLoginRequest data)
    {
        return ResponseEntity.ok(this.authenticationService.loginUser(request, data));
    }

    @PostMapping("/api/user/logout")
    public ResponseEntity<UserActionResponse> logoutUser(HttpServletRequest request)
    {
        return ResponseEntity.ok( this.authenticationService.logoutUser(request) );
    }

    @PostMapping("/api/user/register")
    public ResponseEntity<UserActionResponse> registerUser(@RequestBody UserRegisterRequest data)
    {
        return ResponseEntity.ok( this.authenticationService.registerUser(data) );
    }

}
