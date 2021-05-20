package br.com.itau.beans;

public class Usuario {

	private int id;
	private String nome;
	private String racf;
	private String email;
	private String senha;
	private String foto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public Usuario(int id, String nome, String racf, String email, String senha, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.racf = racf;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
	}
	
	public Usuario() {
		super();
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", racf=" + racf + ", email=" + email + ", senha=" + senha
				+ ", foto=" + foto + "]";
	}
	
	
	
}
