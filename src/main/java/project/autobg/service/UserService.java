package project.autobg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.autobg.model.dto.UserLoginDTO;
import project.autobg.model.dto.UserRegisterDTO;
import project.autobg.model.entity.UserEntity;
import project.autobg.model.mapper.UserMapper;
import project.autobg.repository.UserRepository;
import project.autobg.user.CurrentUser;

import java.util.Optional;

@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
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

        UserEntity newUser = userMapper.userDtoToUserEntity(userRegisterDTO);
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        userRepository.save(newUser);
        login(newUser);

    }

    private void login(UserEntity userEntity) {
        currentUser.
                setLoggedIn(true).
                setName(userEntity.getFirstName()).
                setEmail(userEntity.getEmail());
    }

    public void logout() {
        currentUser.clear();
    }

}
