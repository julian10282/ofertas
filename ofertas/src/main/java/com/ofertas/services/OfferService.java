package com.ofertas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ofertas.repository.OffertRepository;

@Service("offerService")
public class OfferService {
	
	@Autowired
	@Qualifier("offerRepository")
	private OffertRepository offertRepository;

}
