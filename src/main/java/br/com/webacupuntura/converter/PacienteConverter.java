package br.com.webacupuntura.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.webacupuntura.dao.PacienteDAO;
import br.com.webacupuntura.modelo.Paciente;


@Named
public class PacienteConverter implements Converter {

	@Inject
	private PacienteDAO pacienteDAO;
	
	
	
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