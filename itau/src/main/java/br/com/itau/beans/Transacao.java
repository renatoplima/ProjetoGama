package br.com.itau.beans;

import java.util.Date;

public class Transacao {
	
	private int id_transacao;
	private Date data_hora;
	private int dispositivo;
	private float valor_solic;
	private float valor_aut;
	private int status;
	private int ag_financeiro;
	
	public int getId_transacao() {
		return id_transacao;
	}
	public void setId_transacao(int id_transacao) {
		this.id_transacao = id_transacao;
	}
	public Date getData_hora() {
		return data_hora;
	}
	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}
	public int getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(int dispositivo) {
		this.dispositivo = dispositivo;
	}
	public float getValor_solic() {
		return valor_solic;
	}
	public void setValor_solic(float valor_solic) {
		this.valor_solic = valor_solic;
	}
	public float getValor_aut() {
		return valor_aut;
	}
	public void setValor_aut(float valor_aut) {
		this.valor_aut = valor_aut;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getAg_financeiro() {
		return ag_financeiro;
	}
	public void setAg_financeiro(int ag_financeiro) {
		this.ag_financeiro = ag_financeiro;
	}
	
	public Transacao(int id_transacao, Date data_hora, int dispositivo, float valor_solic, float valor_aut, int status,
			int ag_financeiro) {
		super();
		this.id_transacao = id_transacao;
		this.data_hora = data_hora;
		this.dispositivo = dispositivo;
		this.valor_solic = valor_solic;
		this.valor_aut = valor_aut;
		this.status = status;
		this.ag_financeiro = ag_financeiro;
	}
	
	public Transacao() {
		super();
	}
	
	@Override
	public String toString() {
		return "Transacao [id_transacao=" + id_transacao + ", data_hora=" + data_hora + ", dispositivo=" + dispositivo
				+ ", valor_solic=" + valor_solic + ", valor_aut=" + valor_aut + ", status=" + status
				+ ", ag_financeiro=" + ag_financeiro + "]";
	}
	
	
}
