package app.get.userservice;

import app.get.userservice.domains.Role;
import app.get.userservice.domains.User;
import app.get.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
    
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Doe", "john@email.com", "a1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Joana Doe", "joana@email.com", "b5678", new ArrayList<>()));

            userService.addRoleToUser("john@email.com", "ROLE_USER");
            userService.addRoleToUser("joana@email.com", "ROLE_ADMIN");
        };
    }
}
