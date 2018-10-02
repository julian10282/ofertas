package com.ofertas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ofertas.entities.SupplierEntity;
import com.ofertas.repository.SupplierRepository;

@Service("supplierService")
public class SupplierService {

	@Autowired
	@Qualifier("supplierRepository")
	private SupplierRepository supplierRepository;
	
	public SupplierEntity createSupplier (SupplierEntity productEntity) {
		productEntity.setDocument(0);;
		return supplierRepository.save(productEntity);
	}
	
	public boolean removeSupplier (int document) {
		SupplierEntity productEntity = supplierRepository.findByDocument(document);
		if (productEntity != null) {
			supplierRepository.delete(productEntity);
			return true;
		}
		return false;
	}
	
	public SupplierEntity updateSupplier (SupplierEntity productEntity) {
		SupplierEntity productEntity2 = supplierRepository.findByDocument(productEntity.getDocument());
		
		if (productEntity2 !=null) {
			return supplierRepository.save(productEntity);
		}
		return null;
	}
	
	public List<SupplierEntity> findAllSuppliers () {
		return supplierRepository.findAll();
	}
}
