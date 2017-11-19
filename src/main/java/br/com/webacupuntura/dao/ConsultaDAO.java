package br.com.webacupuntura.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.webacupuntura.exception.NegocioException;
import br.com.webacupuntura.jpa.Transactional;
import br.com.webacupuntura.modelo.Consulta;
import br.com.webacupuntura.modelo.DorCabeca;
import br.com.webacupuntura.modeloquery.ConsultaLazy;

public class ConsultaDAO implements Serializable {
	private static final long serialVersionUID = -5594523235200337176L;
	
	@Inject
	private EntityManager em;
	
	@Transactional
	public void excluir(Consulta consulta) throws NegocioException{
		Consulta c = em.find(Consulta.class, consulta.getCodigo());
		em.remove(c);
		em.flush();
	}

	@Transactional
	public void salvar(Consulta consulta) {
		em.merge(consulta);
	}

	
	public Consulta buscarPeloCodigo(Long codigo) {
		return em.find(Consulta.class, codigo);
	}
	
	public List<Consulta> buscarTodas() {

		return  em.createQuery("SELECT c FROM Consulta c JOIN FETCH c.paciente ORDER BY c.data DESC").getResultList();
	}

	

}
