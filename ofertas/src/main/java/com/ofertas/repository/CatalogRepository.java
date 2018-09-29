package com.ofertas.repository;

import com.ofertas.entities.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CatalogRepository extends JpaRepository<CatalogEntity, Serializable> {
}
