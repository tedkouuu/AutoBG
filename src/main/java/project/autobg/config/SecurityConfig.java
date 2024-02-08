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
                                // Require authentication for "/support" path
                                .requestMatchers("/support").authenticated()
                                // Require authentication for any other request
                                .anyRequest().authenticated())
                .formLogin(formLogin -> {
                            formLogin.loginPage("/users/login") // Custom login page URL
                                    .usernameParameter("email") // Username parameter in the login form
                                    .passwordParameter("password") // Password parameter in the login form
                                    .defaultSuccessUrl("/offers/all") // Redirect to "/" on successful login
                                    .failureForwardUrl("/users/login-error"); // Redirect to "/users/login-error" on login failure
                        }
                ).logout(
                        logout -> {
                            logout
                                    // the URL where we should POST something in order to perform the logout
                                    .logoutUrl("/users/logout")
                                    // where to go when logged out?
                                    .logoutSuccessUrl("/")
                                    // invalidate the HTTP session
                                    .invalidateHttpSession(true);
                        })
                .build();

    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new AutoBGUserDetailsService(userRepository);

    }
}
