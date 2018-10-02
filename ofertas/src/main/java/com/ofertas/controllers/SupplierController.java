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

import com.ofertas.entities.SupplierEntity;
import com.ofertas.services.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	@Qualifier("supplierService")
	private SupplierService supplierService;
	
	@PostMapping("/create")
	public ResponseEntity<SupplierEntity> create(@RequestBody SupplierEntity supplierEntity) {
		ResponseEntity<SupplierEntity> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		SupplierEntity supplierEntity2 = supplierService.createSupplier(supplierEntity);
		if (supplierEntity2 != null) {
			responseEntity = new ResponseEntity<>(supplierEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/remove")
	public ResponseEntity<SupplierEntity> remove(@RequestBody SupplierEntity supplierEntity) {
		ResponseEntity<SupplierEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		if (supplierService.removeSupplier(supplierEntity.getDocument())) {
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/update")
	public ResponseEntity<SupplierEntity> update(@RequestBody SupplierEntity supplierEntity) {
		ResponseEntity<SupplierEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		SupplierEntity supplierEntity2 = supplierService.updateSupplier(supplierEntity);
		
		if (supplierEntity2 != null) {
			responseEntity = new ResponseEntity<>(supplierEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<SupplierEntity>> findAll() {
		ResponseEntity<List<SupplierEntity>> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		List<SupplierEntity> supplierEntities = supplierService.findAllSuppliers();
		if (supplierEntities != null) {
			responseEntity = new ResponseEntity<>(supplierEntities, HttpStatus.OK);
		}
		return responseEntity;
	}
}
