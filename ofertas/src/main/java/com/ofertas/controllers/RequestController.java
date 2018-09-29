package com.ofertas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ofertas.services.RequestService;

@Controller
@RequestMapping("/request")
public class RequestController {

	@Autowired
	@Qualifier("requestService")
	private RequestService requestService;
}
