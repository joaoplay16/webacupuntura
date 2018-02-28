package br.com.webacupuntura.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
@Entity
public class InspecaoLingua implements Serializable{

	private Integer codigo;
	private String cor;
	private String saburra;
	private String forma;
	private String umidade;
	private String outrasEspecificacoes;
	private String diagnostico;
	private Boolean R,F,E,BP,VB,P,C;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	@Column(length=80)
	public String getSaburra() {
		return saburra;
	}

	public void setSaburra(String saburra) {
		this.saburra = saburra;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}
	@Column(length=80)
	public String getUmidade() {
		return umidade;
	}

	public void setUmidade(String umidade) {
		this.umidade = umidade;
	}
	@Column(length=300)
	public String getOutrasEspecificacoes() {
		return outrasEspecificacoes;
	}

	public void setOutrasEspecificacoes(String outrasEspecificacoes) {
		this.outrasEspecificacoes = outrasEspecificacoes;
	}
	@Column(length=300)
	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	

	public Boolean getR() {
		return R;
	}

	public void setR(Boolean r) {
		R = r;
	}

	public Boolean getF() {
		return F;
	}

	public void setF(Boolean f) {
		F = f;
	}

	public Boolean getE() {
		return E;
	}

	public void setE(Boolean e) {
		E = e;
	}

	public Boolean getBP() {
		return BP;
	}

	public void setBP(Boolean bP) {
		BP = bP;
	}

	public Boolean getVB() {
		return VB;
	}

	public void setVB(Boolean vB) {
		VB = vB;
	}

	public Boolean getP() {
		return P;
	}

	public void setP(Boolean p) {
		P = p;
	}

	public Boolean getC() {
		return C;
	}

	public void setC(Boolean c) {
		C = c;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InspecaoLingua other = (InspecaoLingua) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	

}
