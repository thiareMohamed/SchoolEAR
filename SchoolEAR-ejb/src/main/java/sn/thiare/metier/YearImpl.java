package sn.thiare.metier;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sn.thiare.entities.Year;
import sn.thiare.interfaces.YearLocal;
import sn.thiare.interfaces.YearRemote;

/**
 * Session Bean implementation class Year
 */
@Stateless
@LocalBean
public class YearImpl implements YearRemote, YearLocal {
	
	@PersistenceContext()
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public YearImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Year create(Year year) {
		em.persist(year);
		return year;
	}

	@Override
	public Year getYear(int id) {
		Year year = em.find(Year.class, id);
		if (year == null) throw new RuntimeException("Not found");
		return year;
	}

	@Override
	public List<Year> getAll() {
		Query req = em.createQuery("SELECT y FROM Year y");
		return req.getResultList();
	}

	@Override
	public void delete(int id) {
		Year year1 = em.find(Year.class, id);
		if (year1 == null) throw new RuntimeException("Not found");
		em.remove(year1);
	}

	@Override
	public Year update(int id, Year year) {
		Year year1 = em.find(Year.class, id);
		if (year1 == null) throw new RuntimeException("Not found");
		return create(year);
	}
    
    

}
