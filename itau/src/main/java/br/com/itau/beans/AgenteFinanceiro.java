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
        private int idAgente;

        @Column(name="nome_agente")
        private String nomeAgente;

        @Column(name="volume_transacional")
        private double volumeTransacional;

        @OneToMany(mappedBy="ag_financeiro", cascade=CascadeType.ALL)
        @JsonIgnoreProperties("ag_financeiro_idAgente")
        private List<Transacao> transacoes;


        @Override
        public String toString() {
                return "AgenteFinanceiro [idAgente=" + idAgente + ", nomeAgente=" + nomeAgente + ", volumeTransacional="
                                + volumeTransacional + ", transacoes=" + transacoes + "]";
        }

        public AgenteFinanceiro(int idAgente, String nomeAgente, double volumeTransacional, List<Transacao> transacoes) {
                super();
                this.idAgente = idAgente;
                this.nomeAgente = nomeAgente;
                this.volumeTransacional = volumeTransacional;
                this.transacoes = transacoes;
        }

        public AgenteFinanceiro() {
                super();
        }

        public int getidAgente() {
                return idAgente;
        }

        public void setidAgente(int idAgente) {
                this.idAgente = idAgente;
        }

        public String getnomeAgente() {
                return nomeAgente;
        }

        public void setnomeAgente(String nomeAgente) {
                this.nomeAgente = nomeAgente;
        }

        public double getvolumeTransacional() {
                return volumeTransacional;
        }

        public void setvolumeTransacional(double volumeTransacional) {
                this.volumeTransacional = volumeTransacional;
        }

        public List<Transacao> getTransacoes() {
                return transacoes;
        }

        public void setTransacoes(List<Transacao> transacoes) {
                this.transacoes = transacoes;
        }

}
