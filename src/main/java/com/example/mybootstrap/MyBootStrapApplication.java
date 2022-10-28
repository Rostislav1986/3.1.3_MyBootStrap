package com.example.mybootstrap;

import com.example.mybootstrap.model.Role;
import com.example.mybootstrap.model.User;
import com.example.mybootstrap.service.RoleService;
import com.example.mybootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MyBootStrapApplication {
    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public MyBootStrapApplication(UserService userService,RoleService roleService){
        this.userService=userService;
        this.roleService=roleService;
    }
    @PostConstruct
    private void dataBaseInit() {
        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");
        Set<Role> adminSet = new HashSet<>();
        Set<Role> userSet = new HashSet<>();

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        adminSet.add(roleAdmin);
        adminSet.add(roleUser);
        userSet.add(roleUser);


        User admin = new User("Admin", "Adminov", 30, "admin@mail.ru", "admin",
                "admin", adminSet);
        User user1 = new User("User", "Userov", 25, "user@mail.ru", "user",
                "user", userSet);
        User user2 = new User("Marat", "Achilov", 23, "marat@mail.ru", "marat",
                "marat", userSet);
        User user3 = new User("Anton", "Volkov", 29, "anton@mail.com", "anton",
                "anton", userSet);

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(admin);
    }


    public static void main(String[] args) {
        SpringApplication.run(MyBootStrapApplication.class, args);
    }

}
