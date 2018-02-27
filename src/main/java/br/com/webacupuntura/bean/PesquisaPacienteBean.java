package br.com.webacupuntura.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.webacupuntura.dao.PacienteDAO;
import br.com.webacupuntura.exception.NegocioException;
import br.com.webacupuntura.modeloquery.PacienteLazy;
import br.com.webacupuntura.relatorio.AoGerarRelatorio;
import br.com.webacupuntura.relatorio.Relatorio;
import br.com.webacupuntura.util.FacesUtil;

@Named("PPBean")
@ViewScoped
public class PesquisaPacienteBean implements 
Serializable, AoGerarRelatorio{

	private static final long serialVersionUID = 1L;

	private PacienteLazy pacienteSelecionado;
	private List<PacienteLazy> pacienteFiltrados;
	private List<PacienteLazy> pacientes = new ArrayList<>();

	@Inject
	private PacienteDAO pacienteDAO;

	@PostConstruct
	public void inicializar() {
		this.pacientes = pacienteDAO.buscarTodos();
	
	}

	public void excluir() {
		try {
			pacienteDAO.excluir(pacienteSelecionado);
			this.pacientes.remove(pacienteSelecionado);
			FacesUtil.addSuccessMessage("Paciente" + pacienteSelecionado.getNome() + " excluído com sucesso.",null);
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage(),null);
		}
	}

	public PacienteLazy getPacienteSelecionado() {
		return pacienteSelecionado;
	}

	public void setPacienteSelecionado(PacienteLazy pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}

	public List<PacienteLazy> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<PacienteLazy> pacientes) {
		this.pacientes = pacientes;
	}

	public List<PacienteLazy> getPacienteFiltrados() {
		return pacienteFiltrados;
	}

	public void setPacienteFiltrados(List<PacienteLazy> pacienteFiltrados) {
		this.pacienteFiltrados = pacienteFiltrados;
	}

	@Override
	public void gerarRelatorio() {
		// TODO Auto-generated method stub
	}

	@Override
	public void gerarRelatorioTodos() {
		if(this.pacientes.size() > 0 ) {
			Relatorio r = new Relatorio();
			r.getRelatorio("rel-paciente", new HashMap<String,Object>());
		}else {
			FacesUtil.addErrorMessage("Não há pacientes para imprimir!", "");
		}
	}
}
