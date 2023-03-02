package com.ap_backend.apirest.services;

import com.ap_backend.apirest.models.IconModel;
import com.ap_backend.apirest.repositories.IIconRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
@Service
@RequiredArgsConstructor
public class IconService {
    private final IIconRepository iconRepository;

    public List<IconModel> icons(){
        return iconRepository.findAll();
    }

    public void guardar(IconModel icon){
        iconRepository.save(icon);


    }

    public boolean borrar(IconModel icon){
        iconRepository.delete(icon);

        return true;
    }
}
