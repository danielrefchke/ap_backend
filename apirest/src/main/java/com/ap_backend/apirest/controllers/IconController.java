package com.ap_backend.apirest.controllers;
import com.ap_backend.apirest.models.IconModel;
import com.ap_backend.apirest.services.IconService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import javax.swing.*;
import java.util.List;
@RestController
@RequestMapping("/icons")
@RequiredArgsConstructor
public class IconController {
    public final IconService iconService;
    @GetMapping()
    public ResponseEntity<List<IconModel>> iconos(){
        return ResponseEntity.ok(iconService.icons());
    }

    @PostMapping()
    public ResponseEntity<IconModel> postIcon(@RequestBody IconModel icon){
        iconService.guardar(icon);
        return ResponseEntity.ok(icon);
    }

    @PutMapping()
    public ResponseEntity<IconModel> putIcon(@RequestBody IconModel icon){
        iconService.guardar(icon);
        return ResponseEntity.ok(icon);
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> deleteIcon(@RequestBody IconModel icon){
        return ResponseEntity.ok(iconService.borrar(icon));
    }

}
