package com.ap_backend.apirest.services;

import com.ap_backend.apirest.configs.FileSystemConfigurationConst;
import com.ap_backend.apirest.exceptions.BadFileException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class FileService {

    public String save(MultipartFile file) throws Exception{

        // Validar que el archivo es una imagen
        if (!file.getContentType().startsWith("image/")) {
            throw new BadFileException("El archivo debe ser una imagen");
        }

        if (file.isEmpty()) {
            throw new BadFileException("0 bytes");
        }
        if(!file.getContentType().matches(FileSystemConfigurationConst.ALLOWED_FILE_TYPE)){
            System.out.println(file.getContentType());
            throw new BadFileException("file type not allowed");
        }

        // Obtiene el nombre original del archivo y lo usa para crear un nuevo archivo en el servidor
        String fileName = file.getOriginalFilename();
        String newFileName =
                FileSystemConfigurationConst.UPLOAD_FOLDER
                + "/"+ fileName;
        File dest = new File(newFileName);
        FileUtils.copyInputStreamToFile(file.getInputStream(), dest);

        // Retorna una respuesta de éxito
        return fileName;
    }

    public Resource loadImage(String filename) throws BadFileException {
        Path filepath = Paths.get(
                FileSystemConfigurationConst.UPLOAD_FOLDER, filename);
        try {
            Resource resource = new UrlResource(filepath.toUri());
            if (resource.exists()
                    && resource.isReadable()
                    && !Files.isDirectory(filepath)){
                return resource;
            }else {
                throw new BadFileException("not found");
            }
        } catch (MalformedURLException e) {
            throw new BadFileException("not found");
        }

    }
    public boolean delete(String file){
        if(file == ""){
            return false;
        }

        Path path = Paths.get(file);
        Path filePath = Paths.get(FileSystemConfigurationConst.UPLOAD_FOLDER, path.getFileName().toString());

        if (Files.isDirectory(filePath)){
            return false;
        }

        try {
            Files.deleteIfExists(filePath);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    ///private
}
