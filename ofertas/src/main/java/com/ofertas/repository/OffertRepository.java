package com.ofertas.repository;

import com.ofertas.entities.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface OffertRepository extends JpaRepository<OfferEntity, Serializable> {
}
