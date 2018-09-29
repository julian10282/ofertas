package com.ofertas.repository;

import com.ofertas.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ProductRepository extends JpaRepository<ProductEntity, Serializable> {
}
