package com.ofertas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ofertas.repository.ItemRepository;

@Service("itemService")
public class ItemService {
	
	@Autowired
	@Qualifier("itemRepository")
	private ItemRepository itemRepository;

}
