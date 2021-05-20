package br.com.itau.beans;

public class AgenteFinanceiro {

	private int id_agente;
	private String nome_agente;
	private double volume_transacional;
	
	public int getId_agente() {
		return id_agente;
	}
	public void setId_agente(int id_agente) {
		this.id_agente = id_agente;
	}
	public String getNome_agente() {
		return nome_agente;
	}
	public void setNome_agente(String nome_agente) {
		this.nome_agente = nome_agente;
	}
	public double getVolume_transacional() {
		return volume_transacional;
	}
	public void setVolume_transacional(double volume_transacional) {
		this.volume_transacional = volume_transacional;
	}
	
	public AgenteFinanceiro(int id_agente, String nome_agente, double volume_transacional) {
		super();
		this.id_agente = id_agente;
		this.nome_agente = nome_agente;
		this.volume_transacional = volume_transacional;
	}
	
	public AgenteFinanceiro() {
		super();
	}
	
	@Override
	public String toString() {
		return "AgenteFinanceiro [id_agente=" + id_agente + ", nome_agente=" + nome_agente + ", volume_transacional="
				+ volume_transacional + "]";
	}
	
	
}
