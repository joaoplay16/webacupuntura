package br.com.webacupuntura.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.webacupuntura.dao.UsuarioDAO;
import br.com.webacupuntura.modelo.Usuario;
import br.com.webacupuntura.util.cdi.CDIServiceLocator;


@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter {

	UsuarioDAO usuarioDAO;
	
	public UsuarioConverter() {
		usuarioDAO = CDIServiceLocator.getBean(UsuarioDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario usuario = null;
		
		if(value != null){
			usuario = usuarioDAO.buscarPeloCodigo(new Long(value));
		}
		
		return usuario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value != null) {
			Long codigo = ((Usuario) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		return "";
	}

}
