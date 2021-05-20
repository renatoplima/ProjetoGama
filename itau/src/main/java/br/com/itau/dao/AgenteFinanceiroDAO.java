package br.com.itau.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.beans.AgenteFinanceiro;

public interface AgenteFinanceiroDAO extends CrudRepository<AgenteFinanceiro, Integer> {

}
