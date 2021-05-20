package br.com.itau.beans;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // fala pro Spring Boot que essa classe possui uma tabela correspondente no DB
@Table(name="MTB310_TRANSACTION")
public class Transacao {
	
	@Id // Avisa o Spring Boot que esta coluna é a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Identity => representa o auto incremento do DB
	@Column(name="id_transacao")
	private int id_transacao;
	
	@Column(name="data_hora")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="dd/MM/yyyy", shape=JsonFormat.Shape.STRING)
	private Date data_hora;
	
	@Column(name="dispositivo")
	private int dispositivo;
	
	@Column(name="valor_solic")
	private float valor_solic;
	
	@Column(name="valor_aut")
	private float valor_aut;
	
	@Column(name="status")
	private int status;
	
	@ManyToOne
	@JsonIgnoreProperties("transacoes")
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
