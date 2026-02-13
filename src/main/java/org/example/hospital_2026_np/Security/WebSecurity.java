package org.example.hospital_2026_np.Security;


import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurity {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/login", "/registration", "/css/**", "/img/**", "/js/**")
                        .permitAll()
                        .requestMatchers("/admin").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/appointments").hasAuthority("ROLE_DOCTOR")
//                        .requestMatchers("/get_medical_records/{id}").hasAuthority("ROLE_DOCTOR")
                        .requestMatchers("/create_medical_record").hasAuthority("ROLE_DOCTOR")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll())
                .logout(logout -> logout.permitAll().logoutSuccessUrl("/"));

        return http.build();
    }

}
