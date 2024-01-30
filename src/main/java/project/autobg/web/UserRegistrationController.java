package project.autobg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.autobg.model.dto.UserRegisterDTO;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserRegisterDTO userRegisterDTO) {
        return "redirect:/";
    }
}
