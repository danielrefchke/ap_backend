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

    public UserModel findByNombre(String usrname) throws EntityNotFoundException{
        return userRepository.findByNombre(usrname).orElseThrow(EntityNotFoundException::new);
    }

    public List<UserModel> usuarios(){
        return userRepository.findAll();
    }

    public void guardar(UserModel user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public boolean borrar(UserModel user){
        userRepository.delete(user);
        return true;
    }


}