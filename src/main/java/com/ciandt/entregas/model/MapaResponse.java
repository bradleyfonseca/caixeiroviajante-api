package com.ciandt.entregas.model;

public class MapaResponse {

	private String rota;
	
	private double custo;

	public String getRota() {
		return rota;
	}

	public void setRota(String rota) {
		this.rota = rota;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	@Override
	public String toString() {
		return "MapaResponse [rota=" + rota + ", custo=" + custo + "]";
	}	
}
