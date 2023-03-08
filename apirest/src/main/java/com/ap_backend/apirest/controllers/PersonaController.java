package com.ap_backend.apirest.controllers;

import com.ap_backend.apirest.models.PersonaModel;
import com.ap_backend.apirest.models.responses.PersonaResponse;
import com.ap_backend.apirest.services.PersonaService;
import com.ap_backend.apirest.views.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaService personaService;

    @JsonView(View.WithCollections.class)
    @GetMapping("/{id}")
    public ResponseEntity<PersonaResponse> getPersonaById(@PathVariable Long id) {
        // Lógica para buscar la persona con el id proporcionado
        Optional<PersonaModel> persona = personaService.getPersonaById(id);

        // Verificar si la persona fue encontrada
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }

        PersonaResponse response = new PersonaResponse();
        PersonaModel p = persona.get();


        BeanUtils.copyProperties(persona.get(),response);

        // Devolver la persona encontrada
        return ResponseEntity.ok(response);
    }

    @PutMapping()
    public ResponseEntity<PersonaModel> putPersona(@RequestBody PersonaModel persona){
        personaService.savePersona(persona);

        return ResponseEntity.ok(persona);
    }

}
