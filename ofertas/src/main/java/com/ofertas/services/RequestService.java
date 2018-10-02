package com.ofertas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ofertas.entities.RequestEntity;
import com.ofertas.repository.RequestRepository;

@Service("requestService")
public class RequestService {

	@Autowired
	@Qualifier("requestRepository")
	private RequestRepository requestRepository;
	
	public RequestEntity createRequest (RequestEntity requestEntity) {
		requestEntity.setId(0);
		return requestRepository.save(requestEntity);
	}
	
	public boolean removeRequest (int id) {
		RequestEntity requestEntity = requestRepository.findById(id);
		if (requestEntity != null) {
			requestRepository.delete(requestEntity);
			return true;
		}
		return false;
	}
	
	public RequestEntity updateRequest (RequestEntity requestEntity) {
		RequestEntity requestEntity2 = requestRepository.findById(requestEntity.getId());
		
		if (requestEntity2 !=null) {
			return requestRepository.save(requestEntity);
		}
		return null;
	}
	
	public List<RequestEntity> findAllRequest () {
		return requestRepository.findAll();
	}
}
