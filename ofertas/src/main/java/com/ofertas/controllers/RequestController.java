package com.ofertas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofertas.services.RequestService;

@RestController
@RequestMapping("/request")
public class RequestController {

	@Autowired
	@Qualifier("requestService")
	private RequestService requestService;
}
