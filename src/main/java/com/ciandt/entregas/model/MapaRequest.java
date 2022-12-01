package com.ciandt.entregas.model;

public class MapaRequest {

	private String origem;
	
	private String destino;
	
	private double autonomia;
	
	private double valorLitro;

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}

	public double getValorLitro() {
		return valorLitro;
	}

	public void setValorLitro(double valorLitro) {
		this.valorLitro = valorLitro;
	}
	
	@Override
	public String toString() {
		return "MapaRequest [origem=" + origem + ", destino=" + destino + ", autonomia=" + autonomia + ", valorLitro="
				+ valorLitro + "]";
	}
}
