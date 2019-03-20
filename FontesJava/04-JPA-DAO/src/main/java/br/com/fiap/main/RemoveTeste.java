package br.com.fiap.main;

import javax.naming.CommunicationException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.impl.EmpresaDAOImpl;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public class RemoveTeste {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

		EntityManager em = fabrica.createEntityManager();

		EmpresaDAO dao = new EmpresaDAOImpl(em);

		try {
			dao.excluir(3);
			dao.commit();
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			System.err.println("Empresa não encontrada");
		} catch (CommitException e) {
			e.printStackTrace();
			System.err.println("Erro ao Excluir");
		}

	}

}
