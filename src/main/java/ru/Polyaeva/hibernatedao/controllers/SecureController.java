package ru.Polyaeva.hibernatedao.controllers;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class SecureController {
    @GetMapping("/read")
    @Secured("ROLE_READ")
    public String onlyRead() {
        return "Wow, you have READ role";
    }

    @GetMapping("/write")
    @RolesAllowed("ROLE_WRITE")
    public String onlyWrite() {
        return "Wow, you have WRITE role";
    }

    @GetMapping("/write-or-delete")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public String writeOrDelete() {
        return "Wow, you have WRITE role";
    }

    @GetMapping("/query")
    @PreAuthorize("#username == authentication.principal.username")
    public String query(@RequestParam String username) {
        return "Wow, you are " + username;
    }
}
