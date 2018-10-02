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

import com.ofertas.entities.CatalogEntity;
import com.ofertas.services.CatalogService;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	@Qualifier("catalogService")
	private CatalogService catalogService;
	
	@PostMapping("/create")
	public ResponseEntity<CatalogEntity> create(@RequestBody CatalogEntity catalogEntity) {
		ResponseEntity<CatalogEntity> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		CatalogEntity catalogEntity2 = catalogService.createCatalog(catalogEntity);
		if (catalogEntity2 != null) {
			responseEntity = new ResponseEntity<>(catalogEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/remove")
	public ResponseEntity<CatalogEntity> remove(@RequestBody CatalogEntity catalogEntity) {
		ResponseEntity<CatalogEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		if (catalogService.removeCatalog(catalogEntity.getCode())) {
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/update")
	public ResponseEntity<CatalogEntity> update(@RequestBody CatalogEntity catalogEntity) {
		ResponseEntity<CatalogEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		CatalogEntity catalogEntity2 = catalogService.updateCatalog(catalogEntity);
		
		if (catalogEntity2 != null) {
			responseEntity = new ResponseEntity<>(catalogEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<CatalogEntity>> findAll() {
		ResponseEntity<List<CatalogEntity>> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		List<CatalogEntity> catalogEntities = catalogService.findAllCatalogs();
		if (catalogEntities != null) {
			responseEntity = new ResponseEntity<>(catalogEntities, HttpStatus.OK);
		}
		return responseEntity;
	}

}
