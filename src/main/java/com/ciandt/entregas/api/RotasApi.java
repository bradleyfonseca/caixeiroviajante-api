package com.ciandt.entregas.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.entregas.exceptions.BusinessException;
import com.ciandt.entregas.model.Rota;
import com.ciandt.entregas.service.RotaService;

@RestController
public class RotasApi {
	
	@Autowired
	private RotaService service;
	
	@PostMapping("/rota")
	public ResponseEntity<List<Rota>> criarRota(@RequestBody Rota request) {
		List<Rota> response = null;
		try {
			service.criarRota(request);
			response = service.listarRota();
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/rota")
	public ResponseEntity<List<Rota>> listarRota() {
		List<Rota> response = null;
		response = service.listarRota();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/rota")
	public ResponseEntity<List<Rota>> excluirRota(@RequestBody Rota request) {
		List<Rota> response = null;
		try {
			service.excluirRota(request);
			response = service.listarRota();
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/rota")
	public ResponseEntity<List<Rota>> alterarRota(@RequestBody Rota request) {
		List<Rota> response = null;
		try {
			service.alterarRota(request);
			response = service.listarRota();
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/carregarRotasPadrao")
	public ResponseEntity<List<Rota>> carregarRotasPadrao() {
		List<Rota> response = null;
		Rota ab = new Rota("A", "B", 10);
		Rota bd = new Rota("B", "D", 15);
		Rota ac = new Rota("A", "C", 20);
		Rota cd = new Rota("C", "D", 30);
		Rota be = new Rota("B", "E", 50);
		Rota de = new Rota("D", "E", 30);
		try {			
			service.criarRota(ab);
			service.criarRota(bd);
			service.criarRota(ac);
			service.criarRota(cd);
			service.criarRota(be);
			service.criarRota(de);
			response = service.listarRota();
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
