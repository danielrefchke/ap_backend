package com.ap_backend.apirest.services;
import com.ap_backend.apirest.models.PersonaModel;
import com.ap_backend.apirest.repositories.IPersonaRepository;
import com.ap_backend.apirest.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PersonaService {
    private final IPersonaRepository personaRepository;
    public List<PersonaModel> Header(){
        return personaRepository.findAll().subList(0,0);
    }
}
