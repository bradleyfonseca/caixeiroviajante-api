package com.ciandt.entregas.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.entregas.model.MapaRequest;
import com.ciandt.entregas.model.MapaResponse;
import com.ciandt.entregas.service.MapaService;

@RestController
public class MapaApi {
	
	@Autowired
	private MapaService service;
	
	@PostMapping("/tracarRota")
	public ResponseEntity<MapaResponse> tracarRota(@RequestBody MapaRequest request) {		
		MapaResponse response = service.calcularRota(request);		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
