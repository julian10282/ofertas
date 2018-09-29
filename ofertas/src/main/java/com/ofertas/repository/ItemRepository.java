package com.ofertas.repository;

import com.ofertas.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ItemRepository extends JpaRepository<ItemEntity, Serializable> {
}
