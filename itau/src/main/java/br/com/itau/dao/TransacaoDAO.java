package br.com.itau.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.beans.Transacao;

public interface TransacaoDAO extends CrudRepository <Transacao, Integer>{

}
