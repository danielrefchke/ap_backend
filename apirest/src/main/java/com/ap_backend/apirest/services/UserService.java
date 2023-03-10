package com.ap_backend.apirest.services;

import com.ap_backend.apirest.models.UserModel;
import com.ap_backend.apirest.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository userRepository;


    public UserModel findByName(String username) throws EntityNotFoundException{
        return userRepository.findByNombre(username).orElseThrow(EntityNotFoundException::new);
    }

    public Optional<UserModel> byId(Long id ){
        return userRepository.findById(id);
    }

    public List<UserModel> users(){
        return userRepository.findAll();
    }

    public void save(UserModel user){
         userRepository.save(user);
    }

    public boolean delete(UserModel user){
        userRepository.delete(user);
        return true;
    }


}