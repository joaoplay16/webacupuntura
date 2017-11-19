package br.com.webacupuntura.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class DorCabeca {
	private Long codigo;
	private Boolean dor1;
	private Boolean dor2;
	private Boolean dor3;
	private Boolean dor4;
	private Boolean dor5;
	private Boolean dor6;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	

	public Boolean getDor1() {
		return dor1;
	}

	public void setDor1(Boolean dor1) {
		this.dor1 = dor1;
	}

	public Boolean getDor2() {
		return dor2;
	}

	public void setDor2(Boolean dor2) {
		this.dor2 = dor2;
	}

	public Boolean getDor3() {
		return dor3;
	}

	public void setDor3(Boolean dor3) {
		this.dor3 = dor3;
	}

	public Boolean getDor4() {
		return dor4;
	}

	public void setDor4(Boolean dor4) {
		this.dor4 = dor4;
	}

	public Boolean getDor5() {
		return dor5;
	}

	public void setDor5(Boolean dor5) {
		this.dor5 = dor5;
	}

	public Boolean getDor6() {
		return dor6;
	}

	public void setDor6(Boolean dor6) {
		this.dor6 = dor6;
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
		DorCabeca other = (DorCabeca) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
