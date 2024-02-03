package project.autobg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatViewController {

    @GetMapping("/support")
    public String showChatView() {
        return "support";
    }
}
