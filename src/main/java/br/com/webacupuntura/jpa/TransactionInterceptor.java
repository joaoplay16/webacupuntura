package br.com.webacupuntura.jpa;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Intercepta as chamadas do método
 * Quando encontrar a anotação @Transactional sera chamado o metodo anotado
 * com @AroundInvoke.
 * @AroundInvoke é chamado antes de executar o método anotado com @Transactional
 * **/
@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Inject EntityManager manager;
	
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		boolean owner = false;

		try {
			if (!transaction.isActive()) {
				// truque para fazer rollback no que já passou
				// (senão, um futuro commit, confirmaria até mesmo operações sem transação)
				transaction.begin();
				transaction.rollback();
				
				// agora sim inicia a transação
				transaction.begin();
				
				owner = true;
			}

			//continua a executar o metodo no caso o salvar()
			return context.proceed();
		} catch (Exception e) {
			if (transaction != null && owner) {
				transaction.rollback();
			}

			throw e;
		} finally {
			if (transaction != null && transaction.isActive() && owner) {
				transaction.commit();
			}
		}
	}
	
}