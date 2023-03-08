package com.ap_backend.apirest.services;

import com.ap_backend.apirest.models.PersonaModel;
import com.ap_backend.apirest.repositories.IPersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaService {
    private final IPersonaRepository personaRepository;

    public Optional<PersonaModel> getPersonaById(Long id){
        return personaRepository.findById(id);
    }

    public void savePersona(PersonaModel persona){
        personaRepository.save(persona);
    }
}
