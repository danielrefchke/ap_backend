package com.ap_backend.apirest.services;

import com.ap_backend.apirest.models.IconModel;
import com.ap_backend.apirest.repositories.IIconRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IconService {
    private final IIconRepository iconRepository;

    public List<IconModel> icons(){
        return iconRepository.findAll();
    }

    public void save(IconModel icon){
        iconRepository.save(icon);


    }

    public boolean delete(IconModel icon){
        iconRepository.delete(icon);

        return true;
    }
}
