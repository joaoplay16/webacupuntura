package webacupuntura.main;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import com.sun.security.ntlm.Client;

import br.com.webacupuntura.dao.PacienteDAO;
import br.com.webacupuntura.modelo.Consulta;
import br.com.webacupuntura.modelo.Paciente;
import br.com.webacupuntura.modelo.Prontuario;
import br.com.webacupuntura.modeloquery.ConsultaLazy;
import br.com.webacupuntura.modeloquery.PacienteLazy;

public class Teste {
	
	static PacienteDAO pdao = new PacienteDAO();
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("webacupunturaPU");
		EntityManager em= emf.createEntityManager();
		
		
/*		Prontuario p = em.find(Prontuario.class,2L);
		
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
*/	

	/*	CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		Root<Prontuario> p  = criteriaQuery.from(Prontuario.class);
		
																
		
		Join<Prontuario, Paciente> prontu = (Join) p.fetch("paciente"); 
		prontu.fetch("nome");
				
		TypedQuery<Object[]> query = em.createQuery(criteriaQuery);
		
		List<Object[]> prontuarios  = query.getResultList();
		
		for(Object[] prontuario: prontuarios){
			System.out.println("CODIGO: "+prontuario[0]);
		//	System.out.println("NOME: "+prontuario.getPaciente().getNome());
			
		}
		*/
		
		
	/*	String jpql = "select pr.codigo, pa.nome from Prontuario pr " +
						"join pr.paciente pa "; 
						
		
			List<Object[]> prontuarios  = em.createQuery(jpql).getResultList();
		
		for(Object[] obj: prontuarios){
			System.out.println("CODIGO: "+obj[0]);
			System.out.println("NOME: "+ obj[1]);
			
		}*/
	/*	
		String jpql = "SELECT p FROM Prontuario p where p.paciente.codigo = :codigo";
		
		Prontuario prontua =  em.createQuery(jpql,Prontuario.class).setParameter("codigo", 1L).getSingleResult();
		
		System.out.println(prontua.getPaciente().getNome());*/
		
/*		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ConsultaLazy> criteriaQuery = builder.createQuery(ConsultaLazy.class);
		Root<Consulta> consulta = criteriaQuery.from(Consulta.class);

		
		criteriaQuery.select(builder.construct(ConsultaLazy.class, 
							consulta.get("data"),
							consulta.get("valor"),
							consulta.get("pago"),
							consulta.get("finalizada"),
							consulta.get("paciente").get("codigo"),
							consulta.get("paciente").get("nome")
							
				));
		
		List<ConsultaLazy> consultas = em.createQuery(criteriaQuery).getResultList();
		for(ConsultaLazy consult: consultas){
			
			System.out.println("NOME: "+ consult.getNomePaciente() + " - Codigo: " +consult.getCodigoPaciente());
			System.out.println("Data: "+ consult.getData());
			System.out.println("Valor: "+ consult.getValor());
			System.out.println("Pago: " + consult.getPago());
			System.out.println("Finalizada: " + consult.getFinalizada());
			System.out.println();
		}*/
		
		/*CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<PacienteLazy> criteriaQuery = builder.createQuery(PacienteLazy.class);
		Root<Consulta> consulta = criteriaQuery.from(Consulta.class);
		
		criteriaQuery.select(builder.construct(PacienteLazy.class, 
								consulta.get("paciente").get("codigo"),
								consulta.get("paciente").get("nome"),
								consulta.get("paciente").get("telefone"),
								consulta.get("paciente").get("celular"),
								consulta.get("paciente").get("email"),
								consulta.get("data"),
								consulta.get("paciente").get("prontuario").get("codigo")
								
							));
		
		List<PacienteLazy> consultas = em.createQuery(criteriaQuery).getResultList();
		for(PacienteLazy paciente: consultas){
			
			System.out.println("NOME: "+ paciente.getNome() + " - Codigo: " +paciente.getCodigo());
			System.out.println("Data: "+ paciente.getDataConsulta());
			System.out.println("Telefone: "+ paciente.getTelefone());
			System.out.println("Celular: " + paciente.getCelular());
			System.out.println("Email: " + paciente.getEmail());
			System.out.println("Codigo paciente: " + paciente.getCodigo());
			System.out.println();
		}*/
		
		/*Paciente p = em.find(Paciente.class, 6l);
				
		p.getConsultas().get(0).setValor(255.0);
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		System.out.println("Valor consulta: " + p.getConsultas().get(0));*/
		
		
		/*List<Consulta> consultas = em.createQuery("SELECT c FROM Consulta c JOIN FETCH c.paciente ORDER BY c.data DESC").getResultList();
		
		Consulta c = consultas.get(0);
		
		c.setValor(3.50);
		
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		*/
		
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<PacienteLazy> criteriaQuery = builder.createQuery(PacienteLazy.class);
		Root<Paciente> paciente = criteriaQuery.from(Paciente.class);
		Join<Paciente,Consulta> u = paciente.join("consultas", JoinType.LEFT);
		criteriaQuery.select(builder.construct(PacienteLazy.class, 
							paciente.get("codigo"),
							paciente.get("nome"),
							paciente.get("telefone"),
							paciente.get("celular"),
							paciente.get("email"),
							builder.max(u.get("data")),
							paciente.get("prontuario").get("codigo")					
							));
		criteriaQuery.groupBy(paciente.get("codigo"));
		List<PacienteLazy > pl =em.createQuery(criteriaQuery).getResultList();
		
	}
}
