package com.ofertas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@PostMapping("/create")
	public ResponseEntity<ClientEntity> create(@RequestBody ClientEntity clientEntity) {
		ResponseEntity<ClientEntity> responseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		
		ClientEntity clientEntity2 = clientService.createClient(clientEntity);
		if (clientEntity2 != null) {
			responseEntity = new ResponseEntity<>(clientEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/remove")
	public ResponseEntity<ClientEntity> remove(@RequestBody ClientEntity clientEntity) {
		ResponseEntity<ClientEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		if (clientService.remove(clientEntity.getDocument())) {
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/update")
	public ResponseEntity<ClientEntity> update(@RequestBody ClientEntity clientEntity) {
		ResponseEntity<ClientEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		ClientEntity clientEntity2 = clientService.updateClient(clientEntity);
		
		if (clientEntity2 != null) {
			responseEntity = new ResponseEntity<>(clientEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ClientEntity>> findAll() {
		ResponseEntity<List<ClientEntity>> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		List<ClientEntity> clientEntity = clientService.findAllClients();
		if (clientEntity != null) {
			responseEntity = new ResponseEntity<>(clientEntity, HttpStatus.OK);
		}
		return responseEntity;
	}
}
