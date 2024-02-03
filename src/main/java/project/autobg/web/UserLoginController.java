package project.autobg.web;

import jakarta.validation.Valid;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.autobg.model.dto.UserLoginDTO;
import project.autobg.model.dto.UserRegisterDTO;
import project.autobg.service.UserService;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String register(Model model) {

        if (!model.containsAttribute("userModel")) {
            model.addAttribute("userModel",
                    new UserLoginDTO());
        }

        return "auth-login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO loginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes
    ) {

        if (bindingResult.hasErrors() || !this.userService.login(loginDTO)) {
            redirectAttributes.addFlashAttribute("userModel", loginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult);
            bindingResult.rejectValue("password", "InvalidPasswordError", "Invalid username or password");
            return "redirect:/users/login";
        }

        userService.login(loginDTO);
        return "redirect:/";
    }
}
