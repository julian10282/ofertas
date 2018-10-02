package com.ofertas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ofertas.entities.CatalogEntity;
import com.ofertas.repository.CatalogRepository;

@Service("catalogService")
public class CatalogService {
	
	@Autowired
	@Qualifier("catalogRepository")
	private CatalogRepository catalogRepository;
	
	public CatalogEntity createCatalog (CatalogEntity catalogEntity) {
		catalogEntity.setCode(0);
		return catalogRepository.save(catalogEntity);
	}
	
	public boolean removeCatalog (int code) {
		CatalogEntity catalogEntity = catalogRepository.findByCode(code);
		if (catalogEntity != null) {
			catalogRepository.delete(catalogEntity);
			return true;
		}
		return false;
	}
	
	public CatalogEntity updateCatalog (CatalogEntity catalogEntity) {
		CatalogEntity catalogEntity2 = catalogRepository.findByCode(catalogEntity.getCode());
		
		if (catalogEntity2 !=null) {
			return catalogRepository.save(catalogEntity);
		}
		return null;
	}
	
	public List<CatalogEntity> findAllCatalogs () {
		return catalogRepository.findAll();
	}

}
