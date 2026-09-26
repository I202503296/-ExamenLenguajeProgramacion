package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Subject;

public class SubjectDAOImplement implements SubjectDAO{
	EntityManagerFactory fabric;
	EntityManager em;
	
	  public SubjectDAOImplement() {
	        fabric = Persistence.createEntityManagerFactory("ExamenT1");
	        em = fabric.createEntityManager();
	    }
	@Override
	public void registrar(Subject subject) {
		try {
			em.getTransaction().begin();
			em.persist(subject);
			em.getTransaction().commit();
		}catch(NullPointerException e) {
			em.getTransaction().rollback();
		}
		
	}


	@Override
	public void editar(Subject subject) {
		 try {
	            em.getTransaction().begin();
	            em.merge(subject);
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            if (em.getTransaction().isActive()) 
	            	em.getTransaction().rollback();
	            e.printStackTrace();
	        }
	
	}

	@Override
	public void eliminar(int id) {
		try {
			em.getTransaction().begin();
			em.remove(id);
			em.getTransaction().commit();
		}catch(NullPointerException e) {
			em.getTransaction().rollback();
		}	
		
	}
	
	@Override
	public Subject find(int id) {
		return em.find(Subject.class, id);
	}


	@Override
	public List<Subject> findAll() {
		Query query= em.createNamedQuery("Subject.findAll");
		
		List<Subject> lista;
		try {
			lista= query.getResultList();
		}catch(Exception e) {
			lista= null;
		}
		return lista;
	}


	
}
