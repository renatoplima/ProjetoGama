package br.com.itau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.itau.beans.AgenteFinanceiro;

public interface AgenteFinanceiroDAO extends CrudRepository<AgenteFinanceiro, Integer> {

        public List<AgenteFinanceiro> findAll();

        @Query(value="select id_agente, nome_agente, volume_transacional from MTB310_ag_financeiro GROUP BY nome_agente ORDER BY volume_transacional desc LIMIT 10", nativeQuery=true)
        public List<AgenteFinanceiro> findByTopTen();

        public List<AgenteFinanceiro> findByNomeAgenteLike(String agente);

}
