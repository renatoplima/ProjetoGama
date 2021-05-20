package br.com.itau.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.beans.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
//	@Query(value="select * from tb_usuario where racf=:usuario or email:email and senha=:senha", nativeQuery=true)
//	public int findByRacfAndEmailAndSenha(@Param("usuario","senha") String usuario, String senha);
	
}
