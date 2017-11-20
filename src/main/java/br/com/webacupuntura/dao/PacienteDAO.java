package br.com.webacupuntura.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.webacupuntura.exception.NegocioException;
import br.com.webacupuntura.jpa.Transactional;
import br.com.webacupuntura.modelo.Consulta;
import br.com.webacupuntura.modelo.Paciente;
import br.com.webacupuntura.modeloquery.PacienteLazy;


public class PacienteDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
		@Inject
		private EntityManager em;
		
		public void salvar(Paciente paciente) {
			em.merge(paciente);
		}
		
		public List<PacienteLazy> buscarTodos() {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<PacienteLazy> criteriaQuery = builder.createQuery(PacienteLazy.class);
			Root<Paciente> paciente = criteriaQuery.from(Paciente.class);
			//Join<Paciente,Consulta> u = paciente.join("consultas", JoinType.LEFT);
			criteriaQuery.select(builder.construct(PacienteLazy.class, 
								paciente.get("codigo"),
								paciente.get("nome"),
								paciente.get("telefone"),
								paciente.get("celular"),
								paciente.get("email"),
								paciente.get("prontuario").get("codigo")					
								));
			//criteriaQuery.groupBy(paciente.get("codigo"));
			return em.createQuery(criteriaQuery).getResultList();
		}
		

		@Transactional
		public void excluir(PacienteLazy paciente) throws NegocioException {
			Paciente pacienteTemp = em.find(Paciente.class, paciente.getCodigo());
			
			em.remove(pacienteTemp);
			em.flush();
		}
		
		public Paciente buscarPeloCodigo(Long codigo) {
			return em.find(Paciente.class, codigo);
		}
		
		public Paciente buscarPeloCodigoLazy(Long codigo){
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Paciente> criteriaQuery = builder.createQuery(Paciente.class);
			Root<Paciente> paciente = criteriaQuery.from(Paciente.class);
			
			criteriaQuery.select(builder.construct(Paciente.class, 
								paciente.<Long>get("codigo"),
								paciente.get("nome"),
								paciente.<Date>get("nascimento"),
								paciente.get("idade"),
								paciente.get("sexo"),
								paciente.get("nacionalidade"),
								paciente.get("naturalidade"),
								paciente.get("estadoCivil"),
								paciente.get("profissao"),
								paciente.get("endereco"),
								paciente.get("bairro"),
								paciente.get("telefone"),
								paciente.get("celular"),
								paciente.get("email"),
								paciente.get("indicacao")
							
								));
			criteriaQuery.where(builder.equal(paciente.get("codigo"), codigo));
			
			return em.createQuery(criteriaQuery).getSingleResult();
		}
		
}


