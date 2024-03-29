package com.ap_backend.apirest.repositories;

import com.ap_backend.apirest.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findByNombre(String nombre);
}
