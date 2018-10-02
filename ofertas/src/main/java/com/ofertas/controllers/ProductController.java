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

import com.ofertas.entities.ProductEntity;
import com.ofertas.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;

	@PostMapping("/create")
	public ResponseEntity<ProductEntity> create(@RequestBody ProductEntity productEntity) {
		ResponseEntity<ProductEntity> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		ProductEntity productEntity2 = productService.createProduct(productEntity);
		if (productEntity2 != null) {
			responseEntity = new ResponseEntity<>(productEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/remove")
	public ResponseEntity<ProductEntity> remove(@RequestBody ProductEntity productEntity) {
		ResponseEntity<ProductEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		if (productService.removeProduct(productEntity.getCode())) {
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/update")
	public ResponseEntity<ProductEntity> update(@RequestBody ProductEntity productEntity) {
		ResponseEntity<ProductEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		ProductEntity productEntity2 = productService.updateProduct(productEntity);
		
		if (productEntity2 != null) {
			responseEntity = new ResponseEntity<>(productEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ProductEntity>> findAll() {
		ResponseEntity<List<ProductEntity>> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		List<ProductEntity> productEntities = productService.findAllProducts();
		if (productEntities != null) {
			responseEntity = new ResponseEntity<>(productEntities, HttpStatus.OK);
		}
		return responseEntity;
	}
}
