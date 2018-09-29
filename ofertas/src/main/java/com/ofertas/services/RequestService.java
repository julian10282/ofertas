package com.ofertas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ofertas.repository.RequestRepository;

@Service("requestService")
public class RequestService {

	@Autowired
	@Qualifier("requestRepository")
	private RequestRepository requestRepository;
}
