package project.autobg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.autobg.model.dto.UserLoginDTO;
import project.autobg.model.dto.UserRegisterDTO;
import project.autobg.model.entity.UserEntity;
import project.autobg.repository.UserRepository;
import project.autobg.user.CurrentUser;

import java.util.Optional;

@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<UserEntity> userOpt = userRepository.
                findByEmail(loginDTO.getUsername());

        if (userOpt.isEmpty()) {
            LOGGER.debug("User with name [{}] not found", loginDTO.getUsername());
            return false;
        }

        String rawPassword = loginDTO.getPassword();
        String encodedPassword = userOpt.get().getPassword();

        boolean success = passwordEncoder.
                matches(rawPassword, encodedPassword);

        if (success) {
            login(userOpt.get());
        } else {
            logout();
        }

        return success;
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {

        UserEntity newUser =
                new UserEntity().
                        setActive(true).
                        setEmail(userRegisterDTO.getEmail()).
                        setFirstName(userRegisterDTO.getFirstName()).
                        setLastName(userRegisterDTO.getLastName()).
                        setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        userRepository.save(newUser);
        login(newUser);

    }

    private void login(UserEntity userEntity) {
        currentUser.
                setLoggedIn(true).
                setName(userEntity.getFirstName());
    }

    public void logout() {
        currentUser.clear();
    }

}
