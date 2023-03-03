package com.ap_backend.apirest.controllers;

import com.ap_backend.apirest.models.UserModel;
import com.ap_backend.apirest.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping()
    public ResponseEntity<List<UserModel>> users(){

        return ResponseEntity.ok(userService.users());
    }

    @PostMapping()
    public ResponseEntity<UserModel> postUser(@RequestBody UserModel request){

        userService.save(request);

        return ResponseEntity.ok(request);
    }

    @PutMapping()
    public ResponseEntity<UserModel> putUser(@RequestBody UserModel request){
        userService.save(request);

        return ResponseEntity.ok(request);
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> deleteUser(@RequestBody UserModel request){
        return ResponseEntity.ok(userService.delete(request));
    }
}