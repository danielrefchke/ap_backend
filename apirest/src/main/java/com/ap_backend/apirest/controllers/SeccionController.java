package com.ap_backend.apirest.controllers;

import com.ap_backend.apirest.models.PersonaModel;
import com.ap_backend.apirest.models.SeccionModel;
import com.ap_backend.apirest.models.requests.SeccionRequest;
import com.ap_backend.apirest.services.PersonaService;
import com.ap_backend.apirest.services.SeccionService;
import com.ap_backend.apirest.views.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seccion")
@RequiredArgsConstructor
public class SeccionController {

    private final SeccionService seccionService;
    private final PersonaService personaService;

    @GetMapping("/{id}")
    @JsonView(View.WithCollections.class)
    public ResponseEntity<List<SeccionModel>> getSecciones(@PathVariable Long id){
        Optional<PersonaModel> persona = personaService.getPersonaById(id);
        if(!persona.isPresent()){
            return ResponseEntity.notFound().build();
        }

        for(SeccionModel s : persona.get().getSecciones() ){
            s.getElementos();
        }

        return ResponseEntity.ok(persona.get().getSecciones());
    }

    @PostMapping("/{id}")
    @JsonView(View.WithCollections.class)
    public ResponseEntity<SeccionModel> postSeccion(
            @RequestBody SeccionRequest seccion, @PathVariable Long id){

        Optional<PersonaModel> persona = personaService.getPersonaById(id);
        if(persona == null){
            return ResponseEntity.notFound().build();
        }


        SeccionModel model = new SeccionModel();
        //ObjectMapper mapper = new ObjectMapper();
        BeanUtils.copyProperties(seccion,model);

        model.setPersona(persona.get());

        seccionService.saveSeccion(model);

        return ResponseEntity.ok(model);
    }

    @PutMapping("/{id}")
    @JsonView(View.WithCollections.class)
    public ResponseEntity<SeccionModel> putSeccion(
            @RequestBody SeccionRequest seccion){

        Optional<SeccionModel> model = seccionService.getById(seccion.getId());
        if(model == null){
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(seccion,model.get());

        //model.setPersona(model.get());

        seccionService.saveSeccion(model.get());

        return ResponseEntity.ok(model.get());
    }

    @DeleteMapping("/{id}")
    @JsonView(View.WithCollections.class)
    public ResponseEntity<Boolean> deleteSeccion(
            @RequestBody SeccionRequest seccion){

        Optional<SeccionModel> model = seccionService.getById(seccion.getId());
        if(!model.isPresent()){
            return ResponseEntity.notFound().build();
        }

        //BeanUtils.copyProperties(seccion,model.get());

        //model.setPersona(model.get());

        seccionService.deleteSeccion(model.get());

        return ResponseEntity.ok(true);
    }
}
