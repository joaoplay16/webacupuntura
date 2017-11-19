package br.com.webacupuntura.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.webacupuntura.dao.PacienteDAO;
import br.com.webacupuntura.modelo.Paciente;
import br.com.webacupuntura.modeloquery.PacienteLazy;
import br.com.webacupuntura.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Paciente.class)
public class PacienteConverter implements Converter {

	private PacienteDAO pacienteDAO;
	
	public PacienteConverter() {
		this.pacienteDAO = CDIServiceLocator.getBean(PacienteDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Paciente retorno = null;

		if (value != null) {
			retorno = this.pacienteDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Paciente) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}