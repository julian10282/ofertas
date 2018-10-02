package com.ofertas.repository;

import com.ofertas.entities.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("offerRepository")
public interface OffertRepository extends JpaRepository<OfferEntity, Serializable> {
	
	public OfferEntity findById (int id);
}
