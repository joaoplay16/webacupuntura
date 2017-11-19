package br.com.webacupuntura.modelo.patologia;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TIPO_PATOLOGIA", discriminatorType=DiscriminatorType.STRING)
public abstract class Patologia {
	private Integer codigo;
	private Boolean individuo;
	private Boolean mae;
	private Boolean pai;
	private Boolean irmao;
	private Boolean avos;
	private String outros;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Boolean getIndividuo() {
		return individuo;
	}

	public void setIndividuo(Boolean individuo) {
		this.individuo = individuo;
	}

	public Boolean getMae() {
		return mae;
	}

	public void setMae(Boolean mae) {
		this.mae = mae;
	}

	public Boolean getPai() {
		return pai;
	}

	public void setPai(Boolean pai) {
		this.pai = pai;
	}

	public Boolean getIrmao() {
		return irmao;
	}

	public void setIrmao(Boolean irmao) {
		this.irmao = irmao;
	}

	public Boolean getAvos() {
		return avos;
	}

	public void setAvos(Boolean avos) {
		this.avos = avos;
	}

	public String getOutros() {
		return outros;
	}

	public void setOutros(String outros) {
		this.outros = outros;
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
		Patologia other = (Patologia) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
