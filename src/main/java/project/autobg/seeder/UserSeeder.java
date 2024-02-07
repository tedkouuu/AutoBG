package project.autobg.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.autobg.service.UserService;

@Component
public class UserSeeder implements CommandLineRunner {

    private final UserService userService;

    public UserSeeder(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userService.init();
    }
}
