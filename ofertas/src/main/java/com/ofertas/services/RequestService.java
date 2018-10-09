package com.ofertas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ofertas.entities.RequestEntity;
import com.ofertas.integration.RestProxy;
import com.ofertas.repository.RequestRepository;

@Service("requestService")
public class RequestService {

	@Autowired
	@Qualifier("requestRepository")
	private RequestRepository requestRepository;
	
	@Autowired
	@Qualifier("restProxy")
	private RestProxy restProxy;
	
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

	public String sendRequestToSupplier(Object body) {
		try {
			
			RequestEntity requestEntity = (RequestEntity) body;
			
			StringBuilder url = new StringBuilder("http://localhost/").append("prueba");
			
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
			String json = gson.toJson(requestEntity);
			
			ResponseEntity<Object> response = restProxy.sendRequest(RequestMethod.POST, url.toString(), null, null, null, json);
			
			RequestEntity result = gson.fromJson(response.getBody().toString(), RequestEntity.class);
			return null;
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
