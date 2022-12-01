package com.ciandt.entregas.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ciandt.entregas.dao.RotaDAO;
import com.ciandt.entregas.exceptions.BusinessException;
import com.ciandt.entregas.model.Rota;

@Repository
public class RotaDAOImpl implements RotaDAO {

	private static List<Rota> rotas = new ArrayList<>();
	
	@Override
	public void inserirRota(Rota rota) throws BusinessException {		
		if(!rotas.contains(rota)) {
			rotas.add(rota);
		} else {
			throw new BusinessException("Rota já existe na base de dados.");
		}
	}

	@Override
	public void alterarRota(Rota rota) throws BusinessException {
		if(rotas.contains(rota)) {
			for (Rota r : rotas) {
				if(r.equals(rota)) {
					r.setDistancia(rota.getDistancia());
				}
			}
		} else {
			throw new BusinessException("Rota não existe na base de dados.");
		}		
	}

	@Override
	public void excluirRota(Rota rota) throws BusinessException {
		if(rotas.contains(rota)) {
			rotas.remove(rota);
		} else {
			throw new BusinessException("Rota não existe na base de dados.");
		}		
	}

	@Override
	public List<Rota> listarRotas() {
		List<Rota> lrotas = new ArrayList<>();
		lrotas.addAll(rotas);
		return lrotas;
	}

	@Override
	public Rota buscarRota(Rota rota) {
		for (Rota r : rotas) {
			if(r.equals(rota)) {
				return r;
			}
		}
		return null;
	}
}
