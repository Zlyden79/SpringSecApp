package ru.netology.zlyden.DaoHibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableMethodSecurity(jsr250Enabled = true, securedEnabled = true)
@RequestMapping("/secure")
public class SecMethController {

    @GetMapping("/reader")
    @Secured("ROLE_READ")
    public String methodReader(){
        return "Этот метод доступен обладателю роли READ";
    }

    @GetMapping("/writer")
    @RolesAllowed("WRITE")
    public String methodWriter(){
        return "Этот метод доступен обладателю роли WRITE";
    }

    @GetMapping("/deleter")
    @RolesAllowed({"WRITE", "DELETE"})
    public String methodDeleter(){
        return "Этот метод доступен обладателю одной из ролей WRITE или DELETE";
    }

    @GetMapping("/withname")
    @PreAuthorize("#name == authentication.principal.username")
    public String methodWithParameterName(@RequestParam String name) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return "Этот метод доступен авторизованному пользователю с соответствующим параметром в запросе: " +
                "имя в запросе - {" + name + "}, " +
                "имя авторизованного пользователя - {" + username + "}";
    }
}
