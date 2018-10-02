package com.ofertas.repository;

import com.ofertas.entities.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("requestRepository")
public interface RequestRepository extends JpaRepository<RequestEntity, Serializable> {
	
	public RequestEntity findById(int id);
}
