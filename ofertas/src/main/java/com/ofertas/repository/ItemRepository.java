package com.ofertas.repository;

import com.ofertas.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<ItemEntity, Serializable> {
	
	public ItemEntity findById(int id);
}
