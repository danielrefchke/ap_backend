package com.ap_backend.apirest.controllers;

import com.ap_backend.apirest.models.UserModel;
import com.ap_backend.apirest.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping()
    public ResponseEntity<List<UserModel>> Usuarios(){
        return ResponseEntity.ok(userService.usuarios());
    }
}