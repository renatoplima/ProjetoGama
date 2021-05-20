package br.com.itau.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.beans.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{

}
