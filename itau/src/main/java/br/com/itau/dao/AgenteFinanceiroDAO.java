package br.com.itau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.itau.beans.AgenteFinanceiro;

public interface AgenteFinanceiroDAO extends CrudRepository<AgenteFinanceiro, Integer> {

	@Query(value="SELECT TOP(10) AG.nome_agente as 'Agente_Financeiro', AG.volume_transacional as 'Volume_Transacional' from dashcards.MTB310_ag_financeiro AG ORDER BY AG.volume_transacional desc", 
			nativeQuery=true)
	List<AgenteFinanceiro> findByTopTen();
}
