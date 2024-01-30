package project.autobg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.autobg.model.dto.UserLoginDTO;
import project.autobg.service.UserService;

@Controller
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginDTO loginDTO) {

        System.out.println("User is logged: " + userService.login(loginDTO));
        return "redirect:/";
    }
}
