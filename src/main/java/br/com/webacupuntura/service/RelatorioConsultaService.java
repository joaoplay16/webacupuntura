package br.com.webacupuntura.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import br.com.webacupuntura.modeloquery.RelatorioConsulta;
import br.com.webacupuntura.relatorio.Relatorio;

public class RelatorioConsultaService implements Serializable{

	private static final long serialVersionUID = -2967116209765381085L;
	
	private Map<String, Object> params ;
	
	public RelatorioConsultaService() {
		
		params = new HashMap<String, Object>();
	}

	public void gerar(Relatorio relatorio,RelatorioConsulta relatorioConsulta) {
		
		if(relatorioConsulta.getDataInicial() != null) {
			String sql = "select c.codigo, p.nome, c.data, c.valor, c.pago, c.finalizada From Consulta c" + 
					" join Paciente p on  p.codigo = c.codigo_paciente " + 
					"where c.data between '" + relatorioConsulta.getDataInicialAsString()
					+ "' and '"+ relatorioConsulta.getDataFinalAsString() + "' ";
			
			if(relatorioConsulta.isIncluirPagoEFinalizado() == true) {
				
				sql += "and c.pago = " + relatorioConsulta.getPaga() +
						" and c.finalizada = " + relatorioConsulta.getFinalizada();
				
			}
			
			params.put("sql", sql);
			
			relatorio.getRelatorio("consulta", params);
		}
		
	}

}
