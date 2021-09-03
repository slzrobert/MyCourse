package com.mycourse.backend.controllers;

import com.mycourse.backend.models.dto.UserDTO;
import com.mycourse.backend.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/usuarios")
    public List<UserDTO> findAllUser(){
        return userService.findAllUser();
    }
}
