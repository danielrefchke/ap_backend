package com.ap_backend.apirest.controllers;

import com.ap_backend.apirest.models.ElementoModel;
import com.ap_backend.apirest.models.SeccionModel;
import com.ap_backend.apirest.models.requests.ElementoRequest;
import com.ap_backend.apirest.services.ElementoService;
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
@RequestMapping("/elemento")
@RequiredArgsConstructor
public class ElementoController {
    private final ElementoService elementoService;
    private final SeccionService seccionService;

    @GetMapping("/{id}")
    @JsonView(View.WithCollections.class)
    public ResponseEntity<List<ElementoModel>> getElementos(@PathVariable Long id){
        Optional<SeccionModel> seccion = seccionService.getById(id);
        if(!seccion.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seccion.get().getElementos());
    }

    @PostMapping("/{id}")
    @JsonView(View.WithCollections.class)
    public ResponseEntity<ElementoModel> postElemento(
            @RequestBody ElementoRequest request,
            @PathVariable Long id){

        Optional<SeccionModel> seccion = seccionService.getById(id);
        if(!seccion.isPresent()){
            return ResponseEntity.notFound().build();
        }

        ElementoModel elemento = new ElementoModel();

        BeanUtils.copyProperties(request,elemento);

        elemento.setSeccion(seccion.get());

        elementoService.saveElemento(elemento);

        return ResponseEntity.ok(elemento);
    }

    @PutMapping("/{id}")
    @JsonView(View.WithCollections.class)
    public ResponseEntity<ElementoModel> putElemento(
            @RequestBody ElementoRequest request,
            @PathVariable Long id){

        Optional<ElementoModel> elemento = elementoService.getById(request.getId());

        if (!elemento.isPresent()){
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(request,elemento.get());

        //elemento.setSeccion(seccion.get());

        elementoService.saveElemento(elemento.get());

        return ResponseEntity.ok(elemento.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteElemento(
            @RequestBody ElementoRequest request,
            @PathVariable Long id){

        Optional<ElementoModel> elemento = elementoService.getById(request.getId());

        if (!elemento.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(elementoService.deleteElemento(elemento.get()));
    }

}
