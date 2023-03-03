package com.ap_backend.apirest.services;
import com.ap_backend.apirest.controllers.ImageController;
import com.ap_backend.apirest.models.ImageModel;
import com.ap_backend.apirest.repositories.IImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@RequiredArgsConstructor
public class ImageService {
    private final IImageRepository imageRepository;

    public List<ImageModel> images(){
        return imageRepository.findAll();
    }

    public void save(ImageModel image){
        imageRepository.save(image);
    }

    public boolean delete(ImageModel image){
        imageRepository.delete(image);
        return true;
    }

}
