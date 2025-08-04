package ru.netology.zlyden.DaoHibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();

        var u1 = User.withUsername("john")
                .password(passwordEncoder().encode("12345"))
                .authorities("search")
                .build();

        var u2 = User.withUsername("jane")
                .password(passwordEncoder().encode("54321"))
                .authorities("read")
                .build();

        var u3 = User.withUsername("rodrigo")
                .password(passwordEncoder().encode("reader"))
                .roles("READ")
                .build();

        var u4 = User.withUsername("william")
                .password(passwordEncoder().encode("writer"))
                .roles("WRITE")
                .build();

        var u5 = User.withUsername("darth")
                .password(passwordEncoder().encode("deleter"))
                .roles("DELETE")
                .build();

        uds.createUser(u1);
        uds.createUser(u2);
        uds.createUser(u3);
        uds.createUser(u4);
        uds.createUser(u5);

        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(Customizer.withDefaults());
        http.authorizeHttpRequests(c -> c.requestMatchers("/persons").permitAll()
                .requestMatchers("/persons/by*").hasAuthority("search")
                .anyRequest().authenticated());
        return http.build();
    }
}
