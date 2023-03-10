package com.ap_backend.apirest.repositories;

import com.ap_backend.apirest.models.ElementoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IElementoRepository extends JpaRepository<ElementoModel,Long> {
}
