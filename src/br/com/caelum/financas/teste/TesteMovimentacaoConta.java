package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		String jpql = "SELECT c FROM Conta c join fetch c.movimentacoes";
		
		Query query = em.createQuery(jpql);
		List<Conta> contas = query.getResultList();
		System.out.println("NContas: "+ contas.size());
		
		
		em.getTransaction().commit();
		em.close();
		
		for (Conta conta : contas) {
			System.out.println(conta.getMovimentacoes().size());
		}

	}

}
