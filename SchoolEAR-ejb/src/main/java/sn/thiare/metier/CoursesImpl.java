package sn.thiare.metier;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sn.thiare.entities.Courses;
import sn.thiare.entities.Inscription;
import sn.thiare.interfaces.CoursesLocal;
import sn.thiare.interfaces.CoursesRemote;

/**
 * Session Bean implementation class Courses
 */
@Stateless
@LocalBean
public class CoursesImpl implements CoursesRemote, CoursesLocal {

	@PersistenceContext()
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public CoursesImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Courses create(Courses courses) {
		em.persist(courses);
		return courses;
	}

	@Override
	public Courses getCourses(int id) {
		Courses courses1 = em.find(Courses.class, id);
		if (courses1 == null) throw new RuntimeException("Not found");
		return courses1;
	}

	@Override
	public List<Courses> getAll() {
		Query req = em.createQuery("SELECT c FROM Courses c");
		return req.getResultList();
	}

	@Override
	public void delete(int id) {
		Courses courses = em.find(Courses.class, id);
		if (courses == null) throw new RuntimeException("Not found");
		em.remove(courses);
	}

	@Override
	public Courses update(int id, Courses courses) {
		Courses courses1 = em.find(Courses.class, id);
		if (courses1 == null) throw new RuntimeException("Not found");
		courses1.setName(courses.getName());
		courses1.setProgramme(courses.getProgramme());
		return courses1;
	}
    
    
    

}
