package com.ofertas.repository;

import com.ofertas.entities.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface RequestRepository extends JpaRepository<RequestEntity, Serializable> {
}
