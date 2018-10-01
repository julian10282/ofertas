package com.ofertas.services;

import java.util.Date;
import java.util.List;

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
		clientEntity.setCreateDate(new Date());
		clientEntity.setModifyDate(new Date());
		return clientRepository.save(clientEntity);
	}
	
	public boolean remove (int document) {
		ClientEntity clientEntity = clientRepository.findByDocument(document);
		if (clientEntity != null) {
			clientRepository.delete(clientEntity);
			return true;
		}
		return false;
	}
	
	public ClientEntity updateClient (ClientEntity clientEntity) {
		ClientEntity clientEntity2 = clientRepository.findByDocument(clientEntity.getDocument());
		
		if (clientEntity2 !=null) {
			clientEntity.setCreateDate(clientEntity2.getCreateDate());
			clientEntity.setModifyDate(new Date());
			return clientRepository.save(clientEntity);
		}
		return null;
	}
	
	public List<ClientEntity> findAllClients () {
		return clientRepository.findAll();
	}
}
