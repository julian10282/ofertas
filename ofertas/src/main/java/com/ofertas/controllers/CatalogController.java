package com.ofertas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofertas.services.CatalogService;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	@Qualifier("catalogService")
	private CatalogService catalogService;

}
