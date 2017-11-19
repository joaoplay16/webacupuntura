package br.com.webacupuntura.modelo;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import br.com.webacupuntura.modelo.patologia.*;

@Entity
public class Prontuario {

	private Long codigo;
	private DorCabeca dorCabeca;
	private InspecaoLingua inspecaoLingua;
	private String pulso;
	private Diagnostico diagnostico;
	private List<Evolucao> evolucoes;
	private Historico historico;
	private Alergia alergia;
	private Alcoolismo alcoolismo;
	private Cancer cancer;
	private Depressao depressao;
	private Diabetes diabetes;
	private DoencasCardiovasculares doencasCardiovasculares;
	private Gastrite gastrite;
	private Hipertensao hipertensao;
	private Hipertireoidismo hipertireoidismo;
	private Hipotireoidismo hipotireoidismo;
	private Obesidade obesidade;
	private ProblemasCirculatorios problemasCirculatorios;
	private Refluxo refluxo;
	private Stress stress;
	private Tabagismo tabagismo;
	private Ulcera ulcera;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_dor_cabeca")
	public DorCabeca getDorCabeca() {
		return dorCabeca;
	}

	public void setDorCabeca(DorCabeca dorCabeca) {
		this.dorCabeca = dorCabeca;
	}

	@Column(length=500)
	public String getPulso() {
		return pulso;
	}

	public void setPulso(String pulso) {
		this.pulso = pulso;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_diagnostico")
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	public List<Evolucao> getEvolucoes() {
		return evolucoes;
	}

	public void setEvolucoes(List<Evolucao> evolucoes) {
		this.evolucoes = evolucoes;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_historico")
	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_alergia")
	public Alergia getAlergia() {
		return alergia;
	}

	public void setAlergia(Alergia alergia) {
		this.alergia = alergia;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_alcoolismo")
	public Alcoolismo getAlcoolismo() {
		return alcoolismo;
	}

	public void setAlcoolismo(Alcoolismo alcoolismo) {
		this.alcoolismo = alcoolismo;
	}


	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_cancer")
	public Cancer getCancer() {
		return cancer;
	}

	public void setCancer(Cancer cancer) {
		this.cancer = cancer;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_depressao")
	public Depressao getDepressao() {
		return depressao;
	}

	
	public void setDepressao(Depressao depressao) {
		this.depressao = depressao;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_diabetes")
	public Diabetes getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Diabetes diabetes) {
		this.diabetes = diabetes;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_dcadiovasculares")
	public DoencasCardiovasculares getDoencasCardiovasculares() {
		return doencasCardiovasculares;
	}

	public void setDoencasCardiovasculares(DoencasCardiovasculares doencasCardiovasculares) {
		this.doencasCardiovasculares = doencasCardiovasculares;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_gastrite")
	public Gastrite getGastrite() {
		return gastrite;
	}

	public void setGastrite(Gastrite gastrite) {
		this.gastrite = gastrite;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_hipertensao")
	public Hipertensao getHipertensao() {
		return hipertensao;
	}

	public void setHipertensao(Hipertensao hipertensao) {
		this.hipertensao = hipertensao;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_hipertireoidismo")
	public Hipertireoidismo getHipertireoidismo() {
		return hipertireoidismo;
	}

	public void setHipertireoidismo(Hipertireoidismo hipertireoidismo) {
		this.hipertireoidismo = hipertireoidismo;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_hipotireoidismo")
	public Hipotireoidismo getHipotireoidismo() {
		return hipotireoidismo;
	}

	public void setHipotireoidismo(Hipotireoidismo hipoTireoidismo) {
		this.hipotireoidismo = hipoTireoidismo;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_obesidade")
	public Obesidade getObesidade() {
		return obesidade;
	}

	public void setObesidade(Obesidade obesidade) {
		this.obesidade = obesidade;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_pcirculatorios")
	public ProblemasCirculatorios getProblemasCirculatorios() {
		return problemasCirculatorios;
	}

	public void setProblemasCirculatorios(ProblemasCirculatorios problemasCirculatorios) {
		this.problemasCirculatorios = problemasCirculatorios;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_refluxo")
	public Refluxo getRefluxo() {
		return refluxo;
	}

	public void setRefluxo(Refluxo refluxo) {
		this.refluxo = refluxo;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_stress")
	public Stress getStress() {
		return stress;
	}

	public void setStress(Stress stress) {
		this.stress = stress;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_tabagismo")
	public Tabagismo getTabagismo() {
		return tabagismo;
	}

	public void setTabagismo(Tabagismo tabagismo) {
		this.tabagismo = tabagismo;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_ulcera")
	public Ulcera getUlcera() {
		return ulcera;
	}

	public void setUlcera(Ulcera ulcera) {
		this.ulcera = ulcera;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_inspecao_ligua")
	public InspecaoLingua getInspecaoLingua() {
		return inspecaoLingua;
	}

	public void setInspecaoLingua(InspecaoLingua inspecaoLingua) {
		this.inspecaoLingua = inspecaoLingua;
	}

}
