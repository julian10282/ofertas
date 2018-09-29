package com.ofertas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ofertas.repository.CatalogRepository;

@Service("catalogService")
public class CatalogService {
	
	@Autowired
	@Qualifier("catalogRepository")
	private CatalogRepository catalogRepository;

}
