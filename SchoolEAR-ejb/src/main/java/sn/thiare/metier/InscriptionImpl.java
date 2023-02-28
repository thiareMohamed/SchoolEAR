package sn.thiare.metier;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sn.thiare.entities.Inscription;
import sn.thiare.entities.Student;
import sn.thiare.interfaces.InscriptionLocal;
import sn.thiare.interfaces.InscriptionRemote;

/**
 * Session Bean implementation class Inscription
 */
@Stateless
@LocalBean
public class InscriptionImpl implements InscriptionRemote, InscriptionLocal {

	@PersistenceContext()
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public InscriptionImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inscription create(Inscription inscription) {
		em.persist(inscription);
		return inscription;
	}

	@Override
	public Inscription getInscription(int id) {
		Inscription inscription = em.find(Inscription.class, id);
		if (inscription == null) throw new RuntimeException("Not found");
		return inscription;
	}

	@Override
	public List<Inscription> getAll() {
		Query req = em.createQuery("SELECT i FROM Inscription i");
		return req.getResultList();
	}

	@Override
	public void delete(int id) {
		Inscription inscription = em.find(Inscription.class, id);
		if (inscription == null) throw new RuntimeException("Not found");
		em.remove(inscription);
	}

	@Override
	public Inscription update(int id, Inscription inscription) {
		Inscription inscription1 = em.find(Inscription.class, id);
		if (inscription1 == null) throw new RuntimeException("Not found");
		return create(inscription);
	}

	@Override
	public List<Inscription> getAllByStudentId(int id) {
		Query req = em.createQuery("SELECT i FROM Inscription i where i.student =" + id);
		return req.getResultList();
	}
	
	
    
    

}
