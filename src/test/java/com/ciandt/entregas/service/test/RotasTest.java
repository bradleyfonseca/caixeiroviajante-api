package com.ciandt.entregas.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ciandt.entregas.exceptions.BusinessException;
import com.ciandt.entregas.model.Rota;
import com.ciandt.entregas.service.RotaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigTest.class})
public class RotasTest {
	
	@Autowired
	private RotaService service;
	
	@Test
	public void criarRota() {
		Rota r = new Rota();
		r.setOrigem("X");
		r.setDestino("Y");
		r.setDistancia(50);
		
		try {
			service.criarRota(r);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		Rota p = service.buscarRota(r);
		Assert.assertEquals(r.toString(), p.toString());
	}
	
	@Test
	public void alterarRota() {		
		Rota r1 = new Rota();
		r1.setOrigem("W");
		r1.setDestino("Z");
		r1.setDistancia(50);
		
		try {
			service.criarRota(r1);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		Rota r2 = new Rota();
		r2.setOrigem("W");
		r2.setDestino("Z");
		r2.setDistancia(5000);
		
		try {
			service.alterarRota(r2);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		Rota p = service.buscarRota(r2);
		Assert.assertEquals(r2, p);
	}
	
	@Test
	public void excluirRota() {
		Rota r = new Rota();
		r.setOrigem("X");
		r.setDestino("Y");
		r.setDistancia(50);
		
		try {
			service.excluirRota(r);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		Rota p = service.buscarRota(r);
		Assert.assertEquals(null, p);
	}	
}
