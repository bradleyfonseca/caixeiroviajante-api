package com.ciandt.entregas.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ciandt.entregas.exceptions.BusinessException;
import com.ciandt.entregas.model.MapaRequest;
import com.ciandt.entregas.model.MapaResponse;
import com.ciandt.entregas.model.Rota;
import com.ciandt.entregas.service.MapaService;
import com.ciandt.entregas.service.RotaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigTest.class})
public class MapaTest {

	@Autowired
	private RotaService rotaService;
	
	@Autowired
	private MapaService mapaService;
	
	@Before
	public void carregaDados() {
		Rota ab = new Rota("A", "B", 10);
		Rota bd = new Rota("B", "D", 15);
		Rota ac = new Rota("A", "C", 20);
		Rota cd = new Rota("C", "D", 30);
		Rota be = new Rota("B", "E", 50);
		Rota de = new Rota("D", "E", 30);
		
		try {
			rotaService.criarRota(ab);
			rotaService.criarRota(bd);
			rotaService.criarRota(ac);
			rotaService.criarRota(cd);
			rotaService.criarRota(be);
			rotaService.criarRota(de);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void tracarRota() {
		MapaRequest novoMapa = new MapaRequest();
		novoMapa.setOrigem("A");
		novoMapa.setDestino("D");
		novoMapa.setAutonomia(10);
		novoMapa.setValorLitro(2.5);
		MapaResponse trajeto = mapaService.calcularRota(novoMapa);
		
		MapaResponse esperado = new MapaResponse();
		esperado.setRota("A B D");
		esperado.setCusto(6.25);
		
		Assert.assertEquals(esperado.toString(), trajeto.toString());
	}
	
}
