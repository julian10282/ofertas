package com.ofertas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ofertas.entities.ItemEntity;
import com.ofertas.repository.ItemRepository;

@Service("itemService")
public class ItemService {
	
	@Autowired
	@Qualifier("itemRepository")
	private ItemRepository itemRepository;
	
	public ItemEntity createItem (ItemEntity itemEntity) {
		itemEntity.setId(0);
		return itemRepository.save(itemEntity);
	}
	
	public boolean removeItem (int code) {
		ItemEntity itemEntity = itemRepository.findById(code);
		if (itemEntity != null) {
			itemRepository.delete(itemEntity);
			return true;
		}
		return false;
	}
	
	public ItemEntity updateItem (ItemEntity itemEntity) {
		ItemEntity itemEntity2 = itemRepository.findById(itemEntity.getId());
		
		if (itemEntity2 !=null) {
			return itemRepository.save(itemEntity);
		}
		return null;
	}
	
	public List<ItemEntity> findAllItems () {
		return itemRepository.findAll();
	}

}
