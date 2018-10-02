package com.ofertas.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ofertas.entities.CatalogEntity;

@Repository("catalogRepository")
public interface CatalogRepository extends JpaRepository<CatalogEntity, Serializable> {

	CatalogEntity findByCode(int document);
}
