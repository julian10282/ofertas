package com.ofertas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ofertas.repository.SupplierRepository;

@Service("supplierService")
public class SupplierService {

	@Autowired
	@Qualifier("supplierRepository")
	private SupplierRepository supplierRepository;
}
