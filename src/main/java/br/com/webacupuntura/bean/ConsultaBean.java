package br.com.webacupuntura.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import br.com.webacupuntura.dao.ConsultaDAO;
import br.com.webacupuntura.exception.NegocioException;
import br.com.webacupuntura.modelo.Consulta;
import br.com.webacupuntura.modelo.Paciente;
import br.com.webacupuntura.modeloquery.RelatorioConsulta;
import br.com.webacupuntura.relatorio.AoGerarRelatorio;
import br.com.webacupuntura.relatorio.Relatorio;
import br.com.webacupuntura.service.RelatorioConsultaService;
import br.com.webacupuntura.util.FacesUtil;

@Named
@ViewScoped
public class ConsultaBean extends RelatorioConsulta
implements Serializable , AoGerarRelatorio{

	private static final long serialVersionUID = 1459680182023053572L;

	private List<Consulta> consultas = new ArrayList<>();
	private Consulta consultaSelecionada;
	private List<Consulta> consultasFiltradas;
	private Consulta consulta;
	private RelatorioConsulta relatorioConsulta;
	@Inject
	private RelatorioConsultaService relatorioConsultaService;

	@Inject
	private ConsultaDAO consultaDAO;

	@PostConstruct
	private void inicializar() {
		limpar();
	}

	public void limpar() {
		this.consulta = new Consulta();
		this.relatorioConsulta = new RelatorioConsulta();
		this.consulta.setPaciente(new Paciente());
		this.consultas = consultaDAO.buscarTodas();
	}

	public void salvar() {
		try {
			consultaDAO.salvar(consultaSelecionada);
			limpar();
			if (consultaSelecionada.getCodigo() == null) {
				FacesUtil.addSuccessMessage("Consulta agendada!", null);

				FacesContext.getCurrentInstance().getExternalContext().redirect("consulta.xhtml");
			}

		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage(), null);
		}
	}

	public void excluir() {
		try {
			if (consultaSelecionada.getCodigo() != null) {
				consultaDAO.excluir(consultaSelecionada);

				FacesUtil.addSuccessMessage("Exclusão de coonsulta",
						"Consulta de " + consultaSelecionada.getPaciente().getNome() + " excluída!", null);
			}
			this.consultas.remove(consultaSelecionada);

			if (consultasFiltradas != null)
				consultasFiltradas.remove(consultaSelecionada);
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Erro ao excluir consulta", null);
		}
	}

	public void adicionar() {
		this.consulta = new Consulta();
		this.consulta.setPaciente(new Paciente());
		this.consultas.add(consulta);
		if (consultasFiltradas != null)
			this.consultasFiltradas.add(consulta);

	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Consulta getConsultaSelecionada() {
		return consultaSelecionada;
	}

	public void setConsultaSelecionada(Consulta consultaSelecionada) {
		this.consultaSelecionada = consultaSelecionada;
	}

	public List<Consulta> getConsultasFiltradas() {
		return consultasFiltradas;
	}

	public void setConsultasFiltradas(List<Consulta> consultasFiltradas) {
		this.consultasFiltradas = consultasFiltradas;
	}

	

	public void onRowEdit(RowEditEvent<Consulta> event) {
		this.consultaSelecionada = (Consulta) event.getObject();
		if (consultaSelecionada.getCodigo() != null) {
			FacesUtil.addSuccessMessage("Atualização de consulta",
					"Consulta de código " + consultaSelecionada.getCodigo() + " atualizada!", null);
		}
		salvar();
	}

	public void onRowCancel(RowEditEvent<Consulta> event) {
		FacesMessage msg = new FacesMessage("Edicao cancelada: ",
				((Consulta) event.getObject()).getPaciente().getNome());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent<Consulta> event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage("mgsConsulta", msg);
		}
	}
	
	public Double getLucroTotal() {
		return consultaDAO.lucroTotal();
	}
	
	public Double getAReceber() {
		return consultaDAO.aReceber();
	}

	public Double getLucroSemanal() {
		return consultaDAO.lucroSemanal();
	}
	
	public Double getLucroMensal() {
		return consultaDAO.lucroMensal();
	}

	public RelatorioConsulta getRelatorioConsulta() {
		return relatorioConsulta;
	}

	@Override
	public void gerarRelatorioTodos() {
		if (consultas.size() > 0) {
			Relatorio relatorio = new Relatorio();
			relatorioConsultaService.gerarTodos(relatorio);
		} else {
			FacesUtil.addErrorMessage("Não há para imprimir", null);
		}
		
	}
	@Override
	public void gerarRelatorio() {
		if (consultas.size() > 0) {
			Relatorio relatorio = new Relatorio();
			relatorioConsultaService.gerar(relatorio,relatorioConsulta);
		} else {
			FacesUtil.addErrorMessage("Não há para imprimir", null);
		}
	}


}
