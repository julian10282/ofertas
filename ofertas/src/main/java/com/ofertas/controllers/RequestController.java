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

import com.ofertas.entities.RequestEntity;
import com.ofertas.services.RequestService;

@RestController
@RequestMapping("/request")
public class RequestController {

	@Autowired
	@Qualifier("requestService")
	private RequestService requestService;
	
	@PostMapping("/create")
	public ResponseEntity<RequestEntity> create(@RequestBody RequestEntity requestEntity) {
		ResponseEntity<RequestEntity> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		RequestEntity requestEntity2 = requestService.createRequest(requestEntity);
		if (requestEntity2 != null) {
			responseEntity = new ResponseEntity<>(requestEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/remove")
	public ResponseEntity<RequestEntity> remove(@RequestBody RequestEntity requestEntity) {
		ResponseEntity<RequestEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		if (requestService.removeRequest(requestEntity.getId())) {
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/update")
	public ResponseEntity<RequestEntity> update(@RequestBody RequestEntity requestEntity) {
		ResponseEntity<RequestEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		RequestEntity requestEntity2 = requestService.updateRequest(requestEntity);
		
		if (requestEntity2 != null) {
			responseEntity = new ResponseEntity<>(requestEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<RequestEntity>> findAll() {
		ResponseEntity<List<RequestEntity>> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		List<RequestEntity> requestEntities = requestService.findAllRequest();
		if (requestEntities != null) {
			responseEntity = new ResponseEntity<>(requestEntities, HttpStatus.OK);
		}
		return responseEntity;
	}
}
