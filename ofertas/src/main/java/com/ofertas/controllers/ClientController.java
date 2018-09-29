package com.ofertas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ofertas.entities.ClientEntity;
import com.ofertas.enumerator.ResponseEnum;
import com.ofertas.model.Response;
import com.ofertas.services.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	@Qualifier("clientService")
	private ClientService clientService;
	
	
	@PostMapping(path="/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Response createCient(@RequestBody ClientEntity clientEntity) {
		Response response = new Response(ResponseEnum.INTERNAL_ERROR);
		ClientEntity clientEntity2 = clientService.createClient(clientEntity);
		if (clientEntity2 != null) {
			response = new Response(ResponseEnum.SUCCESS);
			response.setBody(clientEntity2);
			return response;
		}
		return response;
	}

}
