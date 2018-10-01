package com.ofertas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofertas.services.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	@Qualifier("supplierService")
	private SupplierService supplierService;
}
