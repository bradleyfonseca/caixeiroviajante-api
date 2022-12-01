package com.ciandt.entregas.service;

import com.ciandt.entregas.model.MapaRequest;
import com.ciandt.entregas.model.MapaResponse;

public interface MapaService {

	public MapaResponse calcularRota(final MapaRequest request);
	
}
