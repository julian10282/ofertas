package com.ofertas.repository;

import com.ofertas.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<ProductEntity, Serializable> {
}
