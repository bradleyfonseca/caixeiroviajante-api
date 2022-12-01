package com.ciandt.entregas.service;

import java.util.List;

import com.ciandt.entregas.exceptions.BusinessException;
import com.ciandt.entregas.model.Rota;

public interface RotaService {

	public void criarRota(Rota rota) throws BusinessException;
	
	public void excluirRota(Rota rota) throws BusinessException;
	
	public void alterarRota(Rota rota) throws BusinessException;
	
	public List<Rota> listarRota();
	
	public Rota buscarRota(Rota rota);
	
}
