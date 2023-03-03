package com.ap_backend.apirest.controllers;

import com.ap_backend.apirest.exceptions.BadFileException;
import com.ap_backend.apirest.models.ImageModel;
import com.ap_backend.apirest.services.FileService;
import com.ap_backend.apirest.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {
    public final ImageService imageService;
    public final FileService fileService;

    @GetMapping()
    public ResponseEntity<List<ImageModel>> images(){
        return ResponseEntity.ok(imageService.images());
    }

    @GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> sendImage(@PathVariable String filename){
            try {
                Resource file = fileService.loadImage(filename);
                //String filename = file.getFilename();
                 MediaType mediaType = MediaTypeFactory.getMediaType(filename).orElse(MediaType.APPLICATION_OCTET_STREAM);
                return ResponseEntity.ok()
                        .contentType(mediaType)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                        .body(file);
            }catch (BadFileException e){
                return ResponseEntity.badRequest().build();
            }
    }

    @PostMapping()
    public ResponseEntity<ImageModel> uploadImage(
            @RequestParam("file") MultipartFile file){
        String path;
        ImageModel imagen;

        try {
            path = fileService.save(file);
            imagen = new ImageModel();

            imagen.setUrl(path);

            imageService.save(imagen);

        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }


        return ResponseEntity.ok(imagen);


    }

    @DeleteMapping()
    public ResponseEntity<Boolean> deleteImage(@RequestBody ImageModel image){
        fileService.delete(image.getUrl());
        imageService.delete(image);

        return ResponseEntity.ok(true);
    }
}
