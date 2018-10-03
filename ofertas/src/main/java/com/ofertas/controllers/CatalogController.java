package com.ofertas.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofertas.entities.CatalogEntity;
import com.ofertas.services.CatalogService;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	private static final Log LOG = LogFactory.getLog(CatalogController.class);
	
	@Autowired
	@Qualifier("catalogService")
	private CatalogService catalogService;
	
	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody CatalogEntity catalogEntity) {
		ResponseEntity<Object> responseEntity  = catalogService.createCatalog(catalogEntity);
		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/remove")
	public ResponseEntity<CatalogEntity> remove(@RequestBody CatalogEntity catalogEntity) {
		ResponseEntity<CatalogEntity> responseEntity = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		
		if (catalogService.removeCatalog(catalogEntity.getCode())) {
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> update(@RequestBody CatalogEntity catalogEntity) {
		ResponseEntity<Object> responseEntity = catalogService.updateCatalog(catalogEntity);
		
		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<Object> findAll() {
		ResponseEntity<Object> responseEntity = catalogService.findAllCatalogs();
		
		if (responseEntity.hasBody()) {
			LOG.info("Response " + responseEntity.getBody());
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}

}
