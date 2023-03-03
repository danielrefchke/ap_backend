package com.ap_backend.apirest.repositories;

import com.ap_backend.apirest.models.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IImageRepository extends  JpaRepository<ImageModel,Long>{
}
