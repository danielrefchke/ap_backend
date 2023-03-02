package com.ap_backend.apirest.repositories;

import com.ap_backend.apirest.models.IconModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIconRepository extends JpaRepository<IconModel,Long> {
}
