package com.ofertas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ofertas.entities.ClientEntity;
import com.ofertas.repository.ClientRepository;

@Service("clientService")
public class ClientService {

	@Autowired
	@Qualifier("clientRepository")
	private ClientRepository clientRepository;
	
	public ClientEntity createClient (ClientEntity clientEntity) {
		return clientRepository.save(clientEntity);
	}
}
