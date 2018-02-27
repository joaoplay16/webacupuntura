package br.com.webacupuntura.modeloquery;

import java.io.Serializable;


public class RelatorioPaciente extends RelatorioConsulta implements Serializable {


	private static final long serialVersionUID = 6976914529323976338L;

	private Long quantidade;

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	
}
