package br.com.webacupuntura.modeloquery;

import java.util.Date;

public class ConsultaLazy {

	private Long codigo;
	private Date data;
	private Double valor;
	private Boolean pago;
	private Boolean finalizada;
	private Long codigoPaciente;
	private String nomePaciente;
	
	
	
	public ConsultaLazy(Long codigo,Date data,  Double valor, Boolean pago,
			Boolean finalizada, Long codigoPaciente, String nomePaciente) {
		this.codigo = codigo;
		this.data = data;
		this.valor = valor;
		this.pago = pago;
		this.finalizada = finalizada;
		this.codigoPaciente = codigoPaciente;
		this.nomePaciente = nomePaciente;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Boolean getPago() {
		return pago;
	}
	public void setPago(Boolean pago) {
		this.pago = pago;
	}
	public Boolean getFinalizada() {
		return finalizada;
	}
	public void setFinalizada(Boolean finalizada) {
		this.finalizada = finalizada;
	}
	public Long getCodigoPaciente() {
		return codigoPaciente;
	}
	public void setCodigoPaciente(Long codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	
	
}
