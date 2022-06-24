package repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Cliente;

public class RepositorioCliente {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioCliente() {
		
		emf = Persistence.createEntityManagerFactory("LojaJPA");
		em = emf.createEntityManager();
		
	}
	
	public void salvar(Cliente c) {
		
		
		em.getTransaction().begin();
		c.setCodcliente(em.merge(c).getCodcliente());
		em.getTransaction().commit();
		
		
	}
	
	public void remover(Cliente c) {
		
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listarTodos() {
		
		
		em.getTransaction().begin();
		Query consulta = em.createQuery("select cliente from Cliente cliente");
		List<Cliente> clientes = consulta.getResultList();
		em.getTransaction().commit();
		return clientes;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public Cliente listarCliente(int codCli) {
		
		
		em.getTransaction().begin();
		Query consulta = em.createQuery("select c from Cliente c where c.codcliente = :arg1");
		consulta.setParameter("arg1", codCli);

		
		Cliente cliente = (Cliente) consulta.getSingleResult();
		em.getTransaction().commit();
		return cliente;
		
	}
	
	
	public void finalize() {
		
		emf.close();
		
	}

}
