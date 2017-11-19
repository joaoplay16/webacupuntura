package br.com.webacupuntura.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {
	
	public static void addSuccessMessage(String titulo, String id) {
		FacesContext.getCurrentInstance().addMessage(id, 
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						titulo, null)); 
	}

	public static void addSuccessMessage(String titulo, String message,String id) {
		FacesContext.getCurrentInstance().addMessage(id, 
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						titulo, message)); 
	}
	
	
	public static void addErrorMessage(String message,String id) {
		FacesContext.getCurrentInstance().addMessage(id, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"", message)); 
	}
	
	public static void addErrorMessage(String titulo, String message,String id) {
		FacesContext.getCurrentInstance().addMessage(id, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						titulo, message)); 
	}
	
}