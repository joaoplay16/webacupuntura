package br.com.webacupuntura.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity

@NamedQueries({
	@NamedQuery(name="Consulta.lucroTotal", 
			query="select sum(c.valor) from Consulta c where c.pago = true"),
	@NamedQuery(name="Consulta.aReceber", 
			query="select sum(c.valor) from Consulta c where c.pago = false"),
	@NamedQuery(name="Consulta.lucroMensal",
			query="select sum(c.valor) from Consulta c where c.pago = true and "
			+ "MONTH(c.data) = MONTH(curdate()) and YEAR(c.data) = YEAR(curdate())"),
	@NamedQuery(name="Consulta.lucroSemanal",
			query="select sum(c.valor) from Consulta c where c.pago = true and "
	+ "WEEK(c.data) = WEEK(curdate()) and YEAR(c.data) = YEAR(curdate())")
})
public class Consulta {
	private Long codigo;
	private Date data;
	private Double valor;
	private Boolean pago;
	private Boolean finalizada;	
	private Paciente paciente;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(nullable=false)
	public Date getData() {
		return data;
	}

	
	public void setData(Date data) {
		this.data = data;
	}

	@Column(nullable=false)
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Column(nullable=false)
	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	@Column(nullable=false)
	public Boolean getFinalizada() {
		return finalizada;
	}

	public void setFinalizada(Boolean finalizada) {
		this.finalizada = finalizada;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codigo_paciente",nullable=false)
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return new SimpleDateFormat().format(data);
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
		Consulta other = (Consulta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
}
