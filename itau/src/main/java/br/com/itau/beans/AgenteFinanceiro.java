package br.com.itau.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="MTB310_ag_financeiro")
public class AgenteFinanceiro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_agente")
	private int id_agente;
	
	@Column(name="nome_agente")
	private String nome_agente;
	
	@Column(name="volume_transacional")
	private double volume_transacional;
	
	@OneToMany(mappedBy="ag_financeiro", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("ag_financeiro_id_agente")
	private List<Transacao> transacoes;
	
	
	@Override
	public String toString() {
		return "AgenteFinanceiro [id_agente=" + id_agente + ", nome_agente=" + nome_agente + ", volume_transacional="
				+ volume_transacional + ", transacoes=" + transacoes + "]";
	}

	public AgenteFinanceiro(int id_agente, String nome_agente, double volume_transacional, List<Transacao> transacoes) {
		super();
		this.id_agente = id_agente;
		this.nome_agente = nome_agente;
		this.volume_transacional = volume_transacional;
		this.transacoes = transacoes;
	}

	public AgenteFinanceiro() {
		super();
	}

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

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
	
}