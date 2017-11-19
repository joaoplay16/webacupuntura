package br.com.webacupuntura.service;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import br.com.webacupuntura.dao.PacienteDAO;
import br.com.webacupuntura.jpa.Transactional;
import br.com.webacupuntura.modelo.Paciente;

public class CadastroPacienteService implements Serializable {

	@Inject
	private PacienteDAO pacienteDAO;
	
	@Transactional
	public void salvar(Paciente paciente){
		
		Date dataNasc = paciente.getNascimento();
		
		Date dataAtual = Calendar.getInstance().getTime();
		int anoNasc = dataNasc.getYear();
		int anoAtual = dataAtual.getYear();
		
		int mesNasc = dataNasc.getMonth() +1;
		int mesAtual = dataAtual.getMonth() +1;
		
		int meses = mesAtual - mesNasc;
		System.out.println("Mes ATUAL: "+mesAtual);
		System.out.println("Mes NASC: "+mesNasc);
		System.out.println("Meses: "+meses);
		
		paciente.setIdade(anoAtual-anoNasc);
		
		
		pacienteDAO.salvar(paciente);
	}
}
