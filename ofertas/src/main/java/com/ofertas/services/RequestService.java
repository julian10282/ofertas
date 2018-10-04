package com.ofertas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ofertas.entities.RequestEntity;
import com.ofertas.repository.RequestRepository;

@Service("requestService")
public class RequestService {

	@Autowired
	@Qualifier("requestRepository")
	private RequestRepository requestRepository;
	
	public ResponseEntity<Object> createRequest (RequestEntity requestEntity) {
		try {
			requestEntity.setId(0);
			RequestEntity requestEntity2 = requestRepository.save(requestEntity);

			return new ResponseEntity<>(requestEntity2, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public boolean removeRequest (int id) {
		try {
			RequestEntity requestEntity = requestRepository.findById(id);
			if (requestEntity != null) {
				requestRepository.delete(requestEntity);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public ResponseEntity<Object> updateRequest (RequestEntity requestEntity) {
		try {
			RequestEntity requestEntity2 = requestRepository.findById(requestEntity.getId());
			
			if (requestEntity2 != null) {
				RequestEntity requestEntity3= requestRepository.save(requestEntity);
				return new ResponseEntity<>(requestEntity3, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Object> findAllRequest () {
		try {
			List<RequestEntity> requestEntities = requestRepository.findAll();
			return new ResponseEntity<>(requestEntities, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
