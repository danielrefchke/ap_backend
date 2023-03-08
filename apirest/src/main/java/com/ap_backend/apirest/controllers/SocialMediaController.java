package com.ap_backend.apirest.controllers;

import com.ap_backend.apirest.models.PersonaModel;
import com.ap_backend.apirest.models.SocialMediaModel;
import com.ap_backend.apirest.models.requests.SocialMediaRequest;
import com.ap_backend.apirest.services.PersonaService;
import com.ap_backend.apirest.services.SocialMediaService;
import com.ap_backend.apirest.views.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/social")
@RequiredArgsConstructor
public class SocialMediaController {
    private final SocialMediaService socialMediaService;
    private final PersonaService personaService;
    @GetMapping("/{id}")
    @JsonView(View.WithCollections.class)
    public ResponseEntity<List<SocialMediaModel>> getSocial(@PathVariable Long id){
        Optional<PersonaModel> persona = personaService.getPersonaById(id);
        if(!persona.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persona.get().getRedesSociales());
    }

    @PostMapping("/{id}")
    @JsonView(View.WithCollections.class)
    public ResponseEntity<SocialMediaModel> postSocial(
            @RequestBody SocialMediaRequest social, @PathVariable Long id){

        Optional<PersonaModel> persona = personaService.getPersonaById(id);
        if(persona == null){
            return ResponseEntity.notFound().build();
        }


        SocialMediaModel model = new SocialMediaModel();
        //ObjectMapper mapper = new ObjectMapper();
        BeanUtils.copyProperties(social,model);

        model.setPersona(persona.get());

        socialMediaService.saveSocial(model);

        return ResponseEntity.ok(model);
    }

    @PutMapping("/{id}")
    @JsonView(View.WithCollections.class)
    public ResponseEntity<SocialMediaModel> putSocial(@RequestBody SocialMediaRequest social){
        Optional<SocialMediaModel> model = socialMediaService.getById(social.getId());

        if (!model.isPresent()){
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(social,model.get());

        socialMediaService.saveSocial(model.get());

        return ResponseEntity.ok(model.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteSocial(@RequestBody SocialMediaRequest social){
        Optional<SocialMediaModel> model = socialMediaService.getById(social.getId());

        if (!model.isPresent()){
            return ResponseEntity.notFound().build();
        }

        socialMediaService.deleteSocial(model.get());

        return ResponseEntity.ok(true);
    }

}
