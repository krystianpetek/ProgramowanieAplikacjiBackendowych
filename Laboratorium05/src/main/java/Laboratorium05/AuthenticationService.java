package Laboratorium05;

import Laboratorium05.entities.UserEntity;
import Laboratorium05.repositories.UsersRepository;
import Laboratorium05.response.UserCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AuthenticationService {

    @Autowired
    private UsersRepository usersRepository;

    public boolean isUserLogged(HttpSession session)
    {
        Long loggedUserId = this.getLoggedUserId(session);
        return loggedUserId != null;
    }

    public boolean isUserLogged(HttpServletRequest request)
    {
        return this.isUserLogged(request.getSession());
    }

    public Long getLoggedUserId(HttpSession session)
    {
        return (Long) session.getAttribute("LOGGED_USER_ID");
    }

    public Long getLoggedUserId(HttpServletRequest request)
    {
        return this.getLoggedUserId(request.getSession());
    }

    public UserCheckResponse checkUser(HttpServletRequest request)
    {
        Long loggedUserId = this.getLoggedUserId(request);
        if(loggedUserId == null)
        {
            return new UserCheckResponse( false, "Currently, you are not logged in.", null );
        }
        Optional<UserEntity> userOptional = this.usersRepository.findById(loggedUserId);
    }
}
