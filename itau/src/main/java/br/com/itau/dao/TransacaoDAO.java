package br.com.itau.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.itau.beans.Transacao;

public interface TransacaoDAO extends CrudRepository <Transacao, Integer>{

	@Query(value="select count(id_transacao) as Total from mtb310_transaction inner join mtb310_ag_financeiro on mtb310_ag_financeiro.id_agente = mtb310_transaction.ag_financeiro_id_agente where mtb310_ag_financeiro.id_agente=:codagente and mtb310_transaction.status=:codstatus",
			nativeQuery=true)
	public int findByTotalTransacoesAgenteEStatus(@Param("codagente") int codagente, @Param("codstatus") int codstatus);
}
