package com.ciandt.entregas.dao;

import java.util.List;

import com.ciandt.entregas.exceptions.BusinessException;
import com.ciandt.entregas.model.Rota;

public interface RotaDAO {

	public void inserirRota(final Rota rota) throws BusinessException;
	
	public void alterarRota(final Rota rota) throws BusinessException;
	
	public void excluirRota(final Rota rota) throws BusinessException;
	
	public List<Rota> listarRotas();
	
	public Rota buscarRota(final Rota rota);	
}
