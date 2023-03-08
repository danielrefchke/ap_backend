package com.ap_backend.apirest.controllers;

import com.ap_backend.apirest.models.PersonaModel;
import com.ap_backend.apirest.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaService personaService;

    //@JsonView(View.WithCollections.class)
    @GetMapping("/{id}")
    public ResponseEntity<PersonaModel> getPersonaById(@PathVariable Long id) {
        // Lógica para buscar la persona con el id proporcionado
        Optional<PersonaModel> persona = personaService.getPersonaById(id);

        // Verificar si la persona fue encontrada
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }

        // Devolver la persona encontrada
        return ResponseEntity.ok(persona.get());
    }

    @PutMapping()
    public ResponseEntity<PersonaModel> putPersona(@RequestBody PersonaModel persona){
        personaService.savePersona(persona);

        return ResponseEntity.ok(persona);
    }

}
