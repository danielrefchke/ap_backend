package com.ap_backend.apirest.services;

import com.ap_backend.apirest.models.SeccionModel;
import com.ap_backend.apirest.repositories.ISeccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeccionService {
    private final ISeccionRepository seccionRepository;

    public List<SeccionModel> getSecciones(){
        return seccionRepository.findAll();
    }

    public Optional<SeccionModel> getById(Long id){
        return seccionRepository.findById(id);
    }

    public SeccionModel saveSeccion(SeccionModel seccion){
        seccionRepository.save(seccion);
        return seccion;
    }

    public Boolean deleteSeccion(SeccionModel seccion){
        seccionRepository.delete(seccion);
        return true;
    }

}
