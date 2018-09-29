package com.ofertas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ofertas.entities.ProductEntity;
import com.ofertas.repository.ProductRepository;

@Service("productService")
public class ProductService {
	
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;
	
	public ProductEntity createProduct(ProductEntity productEntity) {
		return productRepository.save(productEntity);
	}
}
