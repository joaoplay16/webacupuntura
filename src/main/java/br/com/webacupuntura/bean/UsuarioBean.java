package br.com.webacupuntura.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.webacupuntura.dao.UsuarioDAO;
import br.com.webacupuntura.exception.NegocioException;
import br.com.webacupuntura.jpa.Transactional;
import br.com.webacupuntura.modelo.Usuario;
import br.com.webacupuntura.util.FacesUtil;


@Named("usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 2153178925400844777L;
	@Inject
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;
	private Usuario usuarioSelecionado;
	private List<Usuario> usuarios;

	@Transactional
	public void excluir() throws NegocioException {
		try {
			usuarioDAO.excluir(usuarioSelecionado);
			this.usuarios.remove(usuarioSelecionado);
			FacesUtil.addSuccessMessage(usuarioSelecionado.getNome() + " excluido!","");
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage(),"");
		}
	}

	@Transactional
	public void salvar() {
		try {
			usuarioDAO.salvar(usuario);
			System.out.println(usuario.getId());

			limpar();
			FacesUtil.addSuccessMessage("Usuario salvo com sucesso!","");
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage(),"");
		}
	}

	@PostConstruct
	private void init() {
		limpar();
		usuarios = usuarioDAO.buscarTodos();
	}

	private void limpar() {
		this.usuario = new Usuario();
		usuarios = usuarioDAO.buscarTodos();
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
