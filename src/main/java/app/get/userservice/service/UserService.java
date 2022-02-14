package app.get.userservice.service;

import app.get.userservice.domains.Role;
import app.get.userservice.domains.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
}
