package com.ciandt.entregas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciandt.entregas.dao.RotaDAO;
import com.ciandt.entregas.exceptions.BusinessException;
import com.ciandt.entregas.model.Rota;
import com.ciandt.entregas.service.RotaService;

@Service
public class RotaServiceImpl implements RotaService {
	
	@Autowired
	private RotaDAO dao;

	@Override
	public void criarRota(Rota rota) throws BusinessException {
		dao.inserirRota(rota);
	}
	
	@Override
	public List<Rota> listarRota() {
		return dao.listarRotas();
	}

	@Override
	public void excluirRota(Rota rota) throws BusinessException {
		dao.excluirRota(rota);
	}

	@Override
	public void alterarRota(Rota rota) throws BusinessException {
		dao.alterarRota(rota);		
	}

	@Override
	public Rota buscarRota(Rota rota) {		
		return dao.buscarRota(rota);
	}

}
