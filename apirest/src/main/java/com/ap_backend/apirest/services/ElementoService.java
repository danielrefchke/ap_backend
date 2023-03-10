package com.ap_backend.apirest.services;

import com.ap_backend.apirest.models.ElementoModel;
import com.ap_backend.apirest.repositories.IElementoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElementoService {
    private final IElementoRepository elementoRepository;

    public Optional<ElementoModel> getById(Long id){
        return elementoRepository.findById(id);
    }
    public List<ElementoModel> getElementos(){
        return elementoRepository.findAll();
    }

    public void saveElemento(ElementoModel elemento){
        elementoRepository.save(elemento);
    }
    @Transactional
    public boolean deleteElemento(ElementoModel elemento){

        elementoRepository.delete(elemento);

        return true;
    }


}
