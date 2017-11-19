package br.com.webacupuntura.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Cria classe no scopo da aplicação
@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;

	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("webacupunturaPU");
	}

	@Produces //sempre que @Inject for usado no EntityManger, irá criar o EntityManagerFactory
	@RequestScoped//Criar o Entity Manager para cada requisição
	public EntityManager create() {
		return factory.createEntityManager();
	}
	
	//@Disposes Sempre que a requisição terminar irá fechar o EntityManager
	public void close(@Disposes EntityManager manager) {
		manager.close();
	}
	
}
