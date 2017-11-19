package br.com.webacupuntura.modeloquery;


import java.util.Date;

public class PacienteLazy {
	private Long codigo;
	private String nome;
	private String telefone;
	private String celular;
	private String email;
	private Long codigoProntuario;
	
	public PacienteLazy(){
		
	}
		

	public PacienteLazy(Long codigo, String nome, String telefone, 
			String celular, String email,Long codigoProntuario) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		
		this.codigoProntuario = codigoProntuario;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCodigoProntuario() {
		return codigoProntuario;
	}

	public void setCodigoProntuario(Long codigoProntuario) {
		this.codigoProntuario = codigoProntuario;
	}

	

	

	
}
