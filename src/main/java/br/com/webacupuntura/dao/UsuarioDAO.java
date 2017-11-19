package br.com.webacupuntura.dao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.webacupuntura.jpa.Transactional;
import br.com.webacupuntura.modelo.Usuario;


public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = -8118844698939807249L;
	
	@Inject
	private EntityManager em;
	
	public void salvar(Usuario usuario) {
		em.merge(usuario);
	}
	
	@Transactional
	public void excluir(Usuario usuario) {
		Usuario usuarioTemp = em.find(Usuario.class, usuario.getId());
		
		em.remove(usuarioTemp);
		em.flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {
		return em.createQuery("from Usuario").getResultList();
	}
	
	public Usuario getUsuarioLogado(Usuario usuario) {
		return (Usuario) em.createQuery("from Usuario u where u.nome = :nome and u.senha = :senha")
				.setParameter("nome", usuario.getNome())
				.setParameter("senha", usuario.getSenha())
				.getSingleResult();
	}
	
	public Usuario buscarPeloCodigo(Long id) {
		return em.find(Usuario.class, id);
	}
}
