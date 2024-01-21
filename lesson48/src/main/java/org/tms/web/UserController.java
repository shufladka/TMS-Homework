package org.tms.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tms.dto.UserDto;
import org.tms.service.DBUserDetailsServiceImpl;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class UserController {

    private final DBUserDetailsServiceImpl userService;

    @PostMapping("/register")
    public String save(UserDto user) {
        userService.save(user);
        return "public";
    }
}