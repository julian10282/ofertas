package com.ofertas.services;

import java.util.List;

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
	
	public ProductEntity createProduct (ProductEntity productEntity) {
		productEntity.setCode(0);
		return productRepository.save(productEntity);
	}
	
	public boolean removeProduct (int code) {
		ProductEntity productEntity = productRepository.findByCode(code);
		if (productEntity != null) {
			productRepository.delete(productEntity);
			return true;
		}
		return false;
	}
	
	public ProductEntity updateProduct (ProductEntity productEntity) {
		ProductEntity productEntity2 = productRepository.findByCode(productEntity.getCode());
		
		if (productEntity2 !=null) {
			return productRepository.save(productEntity);
		}
		return null;
	}
	
	public List<ProductEntity> findAllProducts () {
		return productRepository.findAll();
	}
}
