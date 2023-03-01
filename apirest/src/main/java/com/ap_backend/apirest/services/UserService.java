package com.ap_backend.apirest.services;

import com.ap_backend.apirest.models.UserModel;
import com.ap_backend.apirest.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository userRepository;

    public UserModel findByNombre(String usrname) throws EntityNotFoundException{
        return userRepository.findByNombre(usrname).orElseThrow(EntityNotFoundException::new);
    }

    public List<UserModel> usuarios(){
        return userRepository.findAll();
    }


}