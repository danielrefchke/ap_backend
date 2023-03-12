package com.ap_backend.apirest.controllers;

import com.ap_backend.apirest.configs.AuthenticationConfigConstants;
import com.ap_backend.apirest.models.UserModel;
import com.ap_backend.apirest.models.requests.UserRequest;
import com.ap_backend.apirest.models.responses.UserExistResponse;
import com.ap_backend.apirest.services.UserService;
import com.ap_backend.apirest.views.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    @GetMapping()
    @JsonView(View.BasicData.class)
    public ResponseEntity<List<UserModel>> users(){

        return ResponseEntity.ok(userService.users());
    }

    @GetMapping("/{name}")
    @JsonView(View.BasicData.class)
    public ResponseEntity<UserModel> getUserByName(@PathVariable String name){
        try {
            UserModel testUsuario = userService.findByName(name);

            return ResponseEntity.ok(testUsuario);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("exist/{name}")
    public ResponseEntity<UserExistResponse> existUserByName(@PathVariable String name){
        UserExistResponse response = new UserExistResponse();
        try {
            UserModel testUsuario = userService.findByName(name);

            response.setExist(true);
        }catch (Exception e){
            response.setExist(false);
        }finally {
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping()
    public ResponseEntity<UserModel> postUser(@RequestBody UserRequest request){

        UserModel testUsuario = userService.findByName(request.getNombre());

        if (testUsuario != null){
            return ResponseEntity.unprocessableEntity().build();
        }

        UserModel usuario = new UserModel();

        BeanUtils.copyProperties(request,usuario);

        usuario.setPassword(passwordEncoder.encode(AuthenticationConfigConstants.DEFAULT_PASSWORD));

        userService.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    @PutMapping()
    public ResponseEntity<UserModel> putUser(@RequestBody UserRequest request){

        Optional<UserModel> usuario = userService.byId(request.getId());

        if (!usuario.isPresent()){
            return ResponseEntity.notFound().build();
        }

        String psw = "";
        if((request.getPassword() != "" && request.getPassword() != null)) {

            if(passwordEncoder.encode(request.getPassword()) != usuario.get().getPassword()){
                psw = passwordEncoder.encode(request.getPassword());
            }
        }else {
            psw = usuario.get().getPassword();
        }


        BeanUtils.copyProperties(request,usuario.get());

        usuario.get().setPassword(psw);

        userService.save(usuario.get());

        return ResponseEntity.ok(usuario.get());
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> deleteUser(@RequestBody UserRequest request){
        Optional<UserModel> usuario = userService.byId(request.getId());

        if (!usuario.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userService.delete(usuario.get()));
    }
}