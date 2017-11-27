package br.com.webacupuntura.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import br.com.webacupuntura.dao.UsuarioDAO;
import br.com.webacupuntura.modelo.Usuario;
import br.com.webacupuntura.util.FacesUtil;
import br.com.webacupuntura.util.SessionContext;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 2291553085978694083L;

	@Inject
	private UsuarioDAO usuarioDAO;
	
	private Usuario usuario, usuarioLogado;
	
	public String doLogin() {
		
		try {
			usuarioLogado = usuarioDAO.getUsuarioLogado(usuario);
			if(usuarioLogado!=null){
				SessionContext.getInstance().setAttribute("usuarioLogado", usuarioLogado);
				
			}else{
				FacesUtil.addErrorMessage("Usuario ou senha incorretos","","");
				//return "login.html?faces-redirect=true";
			}
			return "/pages/consulta.html?faces-redirect=true";
		} catch (NoResultException e) {
			FacesUtil.addErrorMessage("Usuário ou senha incorretos!","","");
			return "";
		}
	
	}

	@PostConstruct
	private void init() {
		this.usuario = new Usuario();
	}
	
	public String doLogout() {
		SessionContext.getInstance().encerrarSessao();
        return "/login.html?faces-redirect=true";
     }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
}
