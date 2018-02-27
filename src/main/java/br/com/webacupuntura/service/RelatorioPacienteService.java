package br.com.webacupuntura.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.webacupuntura.modeloquery.RelatorioPaciente;
import br.com.webacupuntura.relatorio.Relatorio;

public class RelatorioPacienteService implements Serializable {


	private static final long serialVersionUID = -6436225503972076233L;

private Map<String, Object> params ;
	
	public RelatorioPacienteService() {
		
		params = new HashMap<String, Object>();
	}

	public void gerar(Relatorio relatorio) {
		String  sql = "select * from Paciente";
	
		params.put("sql", sql);
		
		relatorio.getRelatorio("rel-paciente", params);
	}
}
