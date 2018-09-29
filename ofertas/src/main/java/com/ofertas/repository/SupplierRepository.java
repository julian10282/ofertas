package com.ofertas.repository;

import com.ofertas.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Serializable> {
}
