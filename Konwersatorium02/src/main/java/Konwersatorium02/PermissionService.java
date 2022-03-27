package Konwersatorium02;

import org.springframework.stereotype.Service;

@Service
public class PermissionService {
    public boolean checkPermission(String user) {
        return "root".equals(user);
    }
}
