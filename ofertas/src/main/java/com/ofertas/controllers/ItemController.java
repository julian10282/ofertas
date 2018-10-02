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

import com.ofertas.entities.ItemEntity;
import com.ofertas.services.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	@Qualifier("itemService")
	private ItemService itemService;
	
	@PostMapping("/create")
	public ResponseEntity<ItemEntity> create(@RequestBody ItemEntity itemEntity) {
		ResponseEntity<ItemEntity> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		ItemEntity itemEntity2 = itemService.createItem(itemEntity);
		if (itemEntity2 != null) {
			responseEntity = new ResponseEntity<>(itemEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/remove")
	public ResponseEntity<ItemEntity> remove(@RequestBody ItemEntity itemEntity) {
		ResponseEntity<ItemEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		if (itemService.removeItem(itemEntity.getId())) {
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/update")
	public ResponseEntity<ItemEntity> update(@RequestBody ItemEntity itemEntity) {
		ResponseEntity<ItemEntity> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		ItemEntity itemEntity2 = itemService.updateItem(itemEntity);
		
		if (itemEntity2 != null) {
			responseEntity = new ResponseEntity<>(itemEntity2, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ItemEntity>> findAll() {
		ResponseEntity<List<ItemEntity>> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		List<ItemEntity> itemEntities = itemService.findAllItems();
		if (itemEntities != null) {
			responseEntity = new ResponseEntity<>(itemEntities, HttpStatus.OK);
		}
		return responseEntity;
	}

}
