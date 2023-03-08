package com.ap_backend.apirest.repositories;

import com.ap_backend.apirest.models.SeccionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeccionRepository extends JpaRepository<SeccionModel,Long> {
}
