package com.ofertas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ofertas.entities.OfferEntity;
import com.ofertas.repository.OffertRepository;

@Service("offerService")
public class OfferService {
	
	@Autowired
	@Qualifier("offerRepository")
	private OffertRepository offertRepository;

	public OfferEntity createOffer (OfferEntity offerEntity) {
		offerEntity.setId(0);
		return offertRepository.save(offerEntity);
	}
	
	public boolean removeOffer (int id) {
		OfferEntity offerEntity = offertRepository.findById(id);
		if (offerEntity != null) {
			offertRepository.delete(offerEntity);
			return true;
		}
		return false;
	}
	
	public OfferEntity updateOffer (OfferEntity offerEntity) {
		OfferEntity offerEntity2 = offertRepository.findById(offerEntity.getId());
		
		if (offerEntity2 !=null) {
			return offertRepository.save(offerEntity);
		}
		return null;
	}
	
	public List<OfferEntity> findAllOffers () {
		return offertRepository.findAll();
	}
}
