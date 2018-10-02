package com.ofertas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofertas.entities.OfferEntity;
import com.ofertas.services.OfferService;

@RestController
@RequestMapping("/offer")
public class OfferController {

	@Autowired
	@Qualifier("offerService")
	private OfferService offerService;
	
	@PostMapping("/create")
	public ResponseEntity<OfferEntity> create(@RequestBody OfferEntity offerEntity) {
		ResponseEntity<OfferEntity> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		OfferEntity offerEntity2 = offerService.createOffer(offerEntity);
		if (offerEntity2 != null) {
			responseEntity = new ResponseEntity<>(offerEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/remove")
	public ResponseEntity<OfferEntity> remove(@RequestBody OfferEntity offerEntity) {
		ResponseEntity<OfferEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		if (offerService.remove(offerEntity.getId())) {
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/update")
	public ResponseEntity<OfferEntity> update(@RequestBody OfferEntity offerEntity) {
		ResponseEntity<OfferEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		OfferEntity offerEntity2 = offerService.updateOffer(offerEntity);
		
		if (offerEntity2 != null) {
			responseEntity = new ResponseEntity<>(offerEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<OfferEntity>> findAll() {
		ResponseEntity<List<OfferEntity>> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		List<OfferEntity> offerEntities = offerService.findAllCatalogs();
		if (offerEntities != null) {
			responseEntity = new ResponseEntity<>(offerEntities, HttpStatus.OK);
		}
		return responseEntity;
	}
}
