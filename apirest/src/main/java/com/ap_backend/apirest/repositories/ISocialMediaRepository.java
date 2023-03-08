package com.ap_backend.apirest.repositories;

import com.ap_backend.apirest.models.SocialMediaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISocialMediaRepository extends JpaRepository<SocialMediaModel,Long> {
    public Optional<SocialMediaModel> findById(Long id);
}
