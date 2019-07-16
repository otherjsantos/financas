package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(2);

		String jpql = "SELECT m FROM MOVIMENTACAO m JOIN m.categoria c WHERE c = :pCategoria";
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> movimentacoes = query.getResultList();

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getId());
		}

		em.getTransaction().commit();
		em.close();
	}
}
