package com.ofertas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofertas.entities.ClientEntity;
import com.ofertas.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	@Qualifier("clientService")
	private ClientService clientService;
	
	
	@PostMapping(path="/create")
	public ResponseEntity<ClientEntity> createCient(@RequestBody ClientEntity clientEntity) {
		ResponseEntity<ClientEntity> responseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		
		ClientEntity clientEntity2 = clientService.createClient(clientEntity);
		if (clientEntity2 != null) {
			responseEntity = new ResponseEntity<>(clientEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
}
