package com.ofertas.repository;

import com.ofertas.entities.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("catalogRepository")
public interface CatalogRepository extends JpaRepository<CatalogEntity, Serializable> {
}
