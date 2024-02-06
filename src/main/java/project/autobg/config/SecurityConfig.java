package project.autobg.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import project.autobg.model.enums.UserRoleEnum;
import project.autobg.repository.UserRepository;
import project.autobg.configService.AutoBGUserDetailsService;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        // Allow access to static resources at common locations
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        // Allow access to any endpoint without authentication
                        .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
                        // Allow access to specific paths without authentication
                        .requestMatchers("/", "/users/login", "/users/register").permitAll()
                        // Require the role of MODERATOR for access to "/pages/moderators"
                        .requestMatchers("/pages/moderators").hasRole(UserRoleEnum.MODERATOR.name())
                        // Require the role of ADMIN for access to "/pages/admins"
                        .requestMatchers("/pages/admins").hasRole(UserRoleEnum.ADMIN.name())
                        .requestMatchers("/support").authenticated()
                        // Require authentication for any other request
                        .anyRequest().authenticated()).build();

    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new AutoBGUserDetailsService(userRepository);

    }
}
