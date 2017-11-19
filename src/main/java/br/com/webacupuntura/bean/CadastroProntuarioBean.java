package br.com.webacupuntura.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.TabChangeEvent;

import br.com.webacupuntura.exception.NegocioException;
import br.com.webacupuntura.modelo.*;
import br.com.webacupuntura.modelo.patologia.*;
import br.com.webacupuntura.service.CadastroPacienteService;
import br.com.webacupuntura.util.FacesUtil;

@Named("cadProntuarioB")
@SessionScoped
public class CadastroProntuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroPacienteService cadastroPacienteService;
	private Evolucao evolucaoSelecionada;
	
	private Paciente paciente;
	
	private boolean editEvolucao;
	
	
	public void salvar() throws NegocioException{
		try {
			
			this.cadastroPacienteService.salvar(paciente);
			FacesUtil.addSuccessMessage("Prontuario salvo com sucesso!",null);
			
			System.out.println("Salvando");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Erro desconhecido. Contactar o administrador",null);
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
	}
	
	public void limpar(){
		
		this.paciente = new Paciente();
		this.paciente.setProntuario(new Prontuario());
		
		this.paciente.getProntuario().setAlergia(new Alergia());
		this.paciente.getProntuario().setAlcoolismo(new Alcoolismo());
		this.paciente.getProntuario().setCancer(new Cancer());
		this.paciente.getProntuario().setDepressao(new Depressao());
		this.paciente.getProntuario().setDiabetes(new Diabetes());
		this.paciente.getProntuario().setDoencasCardiovasculares(new DoencasCardiovasculares());
		this.paciente.getProntuario().setGastrite(new Gastrite());
		this.paciente.getProntuario().setHipertensao(new Hipertensao());
		this.paciente.getProntuario().setHipotireoidismo(new Hipotireoidismo());
		this.paciente.getProntuario().setHipertireoidismo(new Hipertireoidismo());
		this.paciente.getProntuario().setObesidade(new Obesidade());
		this.paciente.getProntuario().setProblemasCirculatorios(new ProblemasCirculatorios());
		this.paciente.getProntuario().setRefluxo(new Refluxo());
		this.paciente.getProntuario().setStress(new Stress());
		this.paciente.getProntuario().setTabagismo(new Tabagismo());
		this.paciente.getProntuario().setUlcera(new Ulcera());	
		
		this.paciente.getProntuario().setHistorico(new Historico());
		this.paciente.getProntuario().setInspecaoLingua(new InspecaoLingua());
		this.paciente.getProntuario().setDiagnostico(new Diagnostico());
		this.paciente.getProntuario().setDorCabeca(new DorCabeca());
		this.paciente.getProntuario().setEvolucoes(new ArrayList<>());
		
	}
	
	
	public void adicionarEvolucao() {
		Evolucao e = new Evolucao();
		this.paciente.getProntuario().getEvolucoes().add(e);
	}
	
	public void excluirEvolucao() {
		this.paciente.getProntuario().getEvolucoes().remove(evolucaoSelecionada);
	}
	
	public void atualizarEvolucao(Evolucao e) {
		e.setEdit(true);
	}
	
	public Evolucao getEvolucaoSelecionada() {
		return evolucaoSelecionada;
	}

	public void setEvolucaoSelecionada(Evolucao evolucaoSelecionada) {
		this.evolucaoSelecionada = evolucaoSelecionada;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	public boolean isEditEvolucao() {
		return editEvolucao;
	}

	public void setEditEvolucao(boolean editEvolucao) {
		this.editEvolucao = editEvolucao;
	}

	public void onTabChange(TabChangeEvent event) {
//	        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
//	        FacesContext.getCurrentInstance().addMessage(null, msg);
//	        
	     
	    }
	
}
