package com.ap_backend.apirest.controllers;
import com.ap_backend.apirest.models.PersonaModel;
import com.ap_backend.apirest.services.PersonaService;
import com.ap_backend.apirest.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/header")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaService personaService;

    @GetMapping()
    public ResponseEntity<List<PersonaModel>> header(){
        return ResponseEntity.ok(personaService.Header());
    }
}
