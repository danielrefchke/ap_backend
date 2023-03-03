package com.ap_backend.apirest.services;

import com.ap_backend.apirest.models.UserModel;
import com.ap_backend.apirest.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserModel findByName(String username) throws EntityNotFoundException{
        return userRepository.findByNombre(username).orElseThrow(EntityNotFoundException::new);
    }

    public List<UserModel> users(){
        return userRepository.findAll();
    }

    public void save(UserModel user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public boolean delete(UserModel user){
        userRepository.delete(user);
        return true;
    }


}