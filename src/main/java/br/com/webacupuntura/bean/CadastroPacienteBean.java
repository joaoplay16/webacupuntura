package br.com.webacupuntura.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.webacupuntura.modelo.Diagnostico;
import br.com.webacupuntura.modelo.DorCabeca;
import br.com.webacupuntura.modelo.Historico;
import br.com.webacupuntura.modelo.InspecaoLingua;
import br.com.webacupuntura.modelo.Paciente;
import br.com.webacupuntura.modelo.Prontuario;
import br.com.webacupuntura.modelo.patologia.*;
import br.com.webacupuntura.service.CadastroPacienteService;
import br.com.webacupuntura.util.FacesUtil;

@Named("CPBean")
@ViewScoped
public class CadastroPacienteBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Paciente paciente;

	@Inject
	private CadastroPacienteService CadastroPacienteService;

	public void salvar() {
		try {
			if(paciente.getCodigo() == null){
				FacesUtil.addSuccessMessage("Paciente salvo com sucesso!","msgCadPaciente");
			}else{
			FacesUtil.addSuccessMessage("Paciente atualizado com sucesso!","msgCadPaciente");
			}
			this.CadastroPacienteService.salvar(paciente);
			this.limpar();
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage(),null,"msgCadPaciente");
		}
	}
	

	@PostConstruct
	public void init() {
		this.limpar();
	}
	
	public void limpar(){
		this.paciente=new Paciente();
		Prontuario p = new Prontuario();
		
		p.setAlergia(new Alergia());
		p.setAlcoolismo(new Alcoolismo());
		p.setCancer(new Cancer());
		p.setDepressao(new Depressao());
		p.setDiabetes(new Diabetes());
		p.setDoencasCardiovasculares(new DoencasCardiovasculares());
		p.setGastrite(new Gastrite());
		p.setHipertensao(new Hipertensao());
		p.setHipotireoidismo(new Hipotireoidismo());
		p.setHipertireoidismo(new Hipertireoidismo());
		p.setObesidade(new Obesidade());
		p.setProblemasCirculatorios(new ProblemasCirculatorios());
		p.setRefluxo(new Refluxo());
		p.setStress(new Stress());
		p.setTabagismo(new Tabagismo());
		p.setUlcera(new Ulcera());	
		
		p.setHistorico(new Historico());
		p.setInspecaoLingua(new InspecaoLingua());
		p.setDiagnostico(new Diagnostico());
		p.setDorCabeca(new DorCabeca());
		
		this.paciente.setProntuario(p);
			
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
