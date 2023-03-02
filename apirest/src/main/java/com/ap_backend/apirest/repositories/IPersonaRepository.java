package com.ap_backend.apirest.repositories;
import com.ap_backend.apirest.models.PersonaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface IPersonaRepository extends JpaRepository<PersonaModel,Long> {

}
