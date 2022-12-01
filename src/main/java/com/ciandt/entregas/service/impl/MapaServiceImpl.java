package com.ciandt.entregas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciandt.entregas.dao.RotaDAO;
import com.ciandt.entregas.model.MapaRequest;
import com.ciandt.entregas.model.MapaResponse;
import com.ciandt.entregas.model.Rota;
import com.ciandt.entregas.service.MapaService;

@Service
public class MapaServiceImpl implements MapaService {

	@Autowired
	private RotaDAO dao;
	
	private String melhorCaminho;
	
	private long distanciaCaminho;
	
	@Override
	public MapaResponse calcularRota(MapaRequest request) {		
		MapaResponse response = new MapaResponse();
		if(request == null || request.getOrigem() == null || "".equals(request.getOrigem()) 
				|| request.getDestino() == null || "".equals(request.getDestino()) 
						|| request.getAutonomia() == 0 || request.getValorLitro() == 0) {
			response.setRota("Dados não informados corretamente");
			return response;
		}				
		melhorCaminho = "";
		distanciaCaminho = 0;
		List<Rota> lrotas = dao.listarRotas();
		if (lrotas != null && !lrotas.isEmpty()){
			calcularMelhorRota(request.getOrigem(), request.getDestino(), new StringBuilder(), 0, lrotas);
		} else {
			response.setRota("Não há rotas cadastradas no sistema");
			return response;
		}		
		double qtdeCombustivel = distanciaCaminho/request.getAutonomia();
		double custo = request.getValorLitro()*qtdeCombustivel;		
		response.setRota(melhorCaminho);
		response.setCusto(custo);		
		return response;
	}	
	
	private void calcularMelhorRota(String origem, String destino, StringBuilder melhorRota, long menorDistancia, List<Rota> rotas) {
		melhorRota.append(origem.toUpperCase()).append(" ");
		for (Rota rota : rotas) {
			if(origem.equalsIgnoreCase(rota.getOrigem())) {
				if(destino.equalsIgnoreCase(rota.getDestino())) {
					melhorRota.append(destino.toUpperCase());
					menorDistancia += rota.getDistancia();					
					if(distanciaCaminho == 0 || distanciaCaminho > menorDistancia) {
						distanciaCaminho = menorDistancia;
						melhorCaminho = melhorRota.toString();
						melhorRota.append(origem.toUpperCase()).append(" ");
						menorDistancia = 0;
					}					
				} else {
					calcularMelhorRota(rota.getDestino(), destino, melhorRota, menorDistancia+rota.getDistancia(), rotas);
				}
			}
		}
	}

}
