package br.com.itau.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.itau.beans.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	@Query(value="select * from tb_usuario where racf=:racf or email:email and senha=:senha", nativeQuery=true)
	public int findByRacfAndEmailAndSenha(@Param("racf")String racf, @Param("email")String email, @Param("senha")String senha);
	
	public Usuario findByEmailAndSenha(String email, String senha);
	
}
