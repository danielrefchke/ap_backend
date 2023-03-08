package com.ap_backend.apirest.services;

import com.ap_backend.apirest.models.SocialMediaModel;
import com.ap_backend.apirest.repositories.ISocialMediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocialMediaService {
    private final ISocialMediaRepository socialMediaRepository;

    public List<SocialMediaModel> getSocial(){
       return socialMediaRepository.findAll();
    }

    public Optional<SocialMediaModel> getById(Long id){
        return socialMediaRepository.findById(id);
    }

    public void saveSocial(SocialMediaModel social){
        socialMediaRepository.save(social);
    }

    public boolean deleteSocial(SocialMediaModel social){
        socialMediaRepository.delete(social);
        return true;
    }

}
