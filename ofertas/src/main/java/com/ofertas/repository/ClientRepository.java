package com.ofertas.repository;

import com.ofertas.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ClientRepository extends JpaRepository<ClientEntity, Serializable> {
}
