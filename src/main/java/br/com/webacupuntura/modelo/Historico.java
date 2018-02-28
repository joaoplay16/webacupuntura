package br.com.webacupuntura.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Historico {
	private Integer codigo;
	private String hDoencaAtual;
	private String hPatologico;
	private String hFamiliar;
	private String hSocial;
	private String tratamentoAtual;
	private String tratamentosAnteriores;
	private String medicamentoEmUso;
	private String examesApresentados;
	private String diagnosticoMedico;
	private String medico;
	private String sistemaCirculatorio;
	private String sistemaMuscular;
	private String sistemaNervoso;
	private String sistemaOsseo;
	private String sistemaRespiratorio;
	private String sistemaGastroIntestinal;
	private String sistemaGeniturinario;
	private Integer sono;
	private String cirurgias;
	private String alimentacao;
	private String cicloMenstrual;
	private String atividadeSexual;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	@Column(length=270)
	public String gethDoencaAtual() {
		return hDoencaAtual;
	}

	public void sethDoencaAtual(String hDoencaAtual) {
		this.hDoencaAtual = hDoencaAtual;
	}
	@Column(length=270)
	public String gethPatologico() {
		return hPatologico;
	}

	public void sethPatologico(String hPatologico) {
		this.hPatologico = hPatologico;
	}
	@Column(length=270)
	public String gethFamiliar() {
		return hFamiliar;
	}

	public void sethFamiliar(String hFamiliar) {
		this.hFamiliar = hFamiliar;
	}
	@Column(length=270)
	public String gethSocial() {
		return hSocial;
	}

	public void sethSocial(String hSocial) {
		this.hSocial = hSocial;
	}
	@Column(length=200)
	public String getTratamentoAtual() {
		return tratamentoAtual;
	}

	public void setTratamentoAtual(String tratamentoAtual) {
		this.tratamentoAtual = tratamentoAtual;
	}
	@Column(length=200)
	public String getTratamentosAnteriores() {
		return tratamentosAnteriores;
	}

	public void setTratamentosAnteriores(String tratamentosAnteriores) {
		this.tratamentosAnteriores = tratamentosAnteriores;
	}
	@Column(length=200)
	public String getMedicamentoEmUso() {
		return medicamentoEmUso;
	}

	public void setMedicamentoEmUso(String medicamentoEmUso) {
		this.medicamentoEmUso = medicamentoEmUso;
	}
	@Column(length=270)
	public String getExamesApresentados() {
		return examesApresentados;
	}

	public void setExamesApresentados(String examesApresentados) {
		this.examesApresentados = examesApresentados;
	}
	@Column(length=270)
	public String getDiagnosticoMedico() {
		return diagnosticoMedico;
	}

	public void setDiagnosticoMedico(String diagnosticoMedico) {
		this.diagnosticoMedico = diagnosticoMedico;
	}
	@Column(length=80)
	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}
	@Column(length=270)
	public String getSistemaCirculatorio() {
		return sistemaCirculatorio;
	}

	public void setSistemaCirculatorio(String sistemaCirculatorio) {
		this.sistemaCirculatorio = sistemaCirculatorio;
	}
	@Column(length=270)
	public String getSistemaMuscular() {
		return sistemaMuscular;
	}

	public void setSistemaMuscular(String sistemaMuscular) {
		this.sistemaMuscular = sistemaMuscular;
	}
	@Column(length=270)
	public String getSistemaNervoso() {
		return sistemaNervoso;
	}

	public void setSistemaNervoso(String sistemaNervoso) {
		this.sistemaNervoso = sistemaNervoso;
	}
	@Column(length=270)
	public String getSistemaOsseo() {
		return sistemaOsseo;
	}

	public void setSistemaOsseo(String sistemaOsseo) {
		this.sistemaOsseo = sistemaOsseo;
	}
	@Column(length=270)
	public String getSistemaRespiratorio() {
		return sistemaRespiratorio;
	}

	public void setSistemaRespiratorio(String sistemaRespiratorio) {
		this.sistemaRespiratorio = sistemaRespiratorio;
	}
	@Column(length=270)
	public String getSistemaGastroIntestinal() {
		return sistemaGastroIntestinal;
	}

	public void setSistemaGastroIntestinal(String sistemaGastroIntestinal) {
		this.sistemaGastroIntestinal = sistemaGastroIntestinal;
	}
	@Column(length=270)
	public String getSistemaGeniturinario() {
		return sistemaGeniturinario;
	}
	
	public void setSistemaGeniturinario(String sistemaGeniturinario) {
		this.sistemaGeniturinario = sistemaGeniturinario;
	}

	public Integer getSono() {
		return sono;
	}

	public void setSono(Integer sono) {
		this.sono = sono;
	}
	@Column(length=270)
	public String getCirurgias() {
		return cirurgias;
	}

	public void setCirurgias(String cirurgias) {
		this.cirurgias = cirurgias;
	}
	@Column(length=270)
	public String getAlimentacao() {
		return alimentacao;
	}

	public void setAlimentacao(String alimentacao) {
		this.alimentacao = alimentacao;
	}
	@Column(length=270)
	public String getCicloMenstrual() {
		return cicloMenstrual;
	}

	public void setCicloMenstrual(String cicloMenstrual) {
		this.cicloMenstrual = cicloMenstrual;
	}
	@Column(length=270)
	public String getAtividadeSexual() {
		return atividadeSexual;
	}

	public void setAtividadeSexual(String atividadeSexual) {
		this.atividadeSexual = atividadeSexual;
	}

	

}
