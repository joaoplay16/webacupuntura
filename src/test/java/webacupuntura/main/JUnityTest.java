package webacupuntura.main;

import static org.junit.Assert.assertEquals;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class JUnityTest {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("webacupunturaPU");
	EntityManager em= emf.createEntityManager();
	
	
	@Test
	public void lucroTotal() {
		String jpql = "select sum(c.valor) from Consulta c "
				+ " where c.pago = true ";
		
		Double valor = (Double) em.createQuery(jpql).getSingleResult();
		
		System.out.println(valor);

	}
	
	@Test
	public void lucroSemanal() {
		String jpql = "select sum(c.valor) from Consulta c "
				+ " where c.pago = true and week(c.data) = week(curtime())"
				+ " and year(c.data) = year(curtime())";
		
		Double valor = (Double) em.createQuery(jpql).getSingleResult();
		
		System.out.println(valor);

	}
	
	@Test
	public void lucroMensal() {
		String jpql = "select sum(c.valor) from Consulta c "
				+ " where c.pago = true and MONTH(c.data) = MONTH(curdate())"
				+ " and year(c.data) = year(curdate())";
		
		Double valor = em.createNamedQuery("Consulta.lucroMensal", Double.class).getSingleResult();
		
		System.out.println(valor);

	}
	
	@Test
	public void aReceber() {
		String jpql = "select sum(c.valor) from Consulta c "
				+ " where c.pago = false";
		
		Double valor = (Double) em.createQuery(jpql).getSingleResult();
		
		System.out.println(valor);

	}
	

	@Test
	public void dataAtual() {
		String jpql = "select curdate()";
		
	em.createQuery(jpql).getSingleResult();
		
		System.out.println();

	}
}
