package sn.thiare.metier;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sn.thiare.entities.Student;
import sn.thiare.entities.Year;
import sn.thiare.interfaces.StudentLocal;
import sn.thiare.interfaces.StudentRemote;

/**
 * Session Bean implementation class Student
 */
@Stateless
@LocalBean
public class StudentImpl implements StudentRemote, StudentLocal {

	
	@PersistenceContext()
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public StudentImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Student create(Student student) {
		em.persist(student);
		return student;
	}

	@Override
	public Student getStudent(int id) {
		Student student = em.find(Student.class, id);
		if (student == null) throw new RuntimeException("Not found");
		return student;
	}

	@Override
	public List<Student> getAll() {
		Query req = em.createQuery("SELECT y FROM Student y");
		return req.getResultList();
	}

	@Override
	public void delete(int id) {
		Student student = em.find(Student.class, id);
		if (student == null) throw new RuntimeException("Not found");
		em.remove(student);
	}

	@Override
	public Student update(int id, Student student) {
		Student studen1 = em.find(Student.class, id);
		if (studen1 == null) throw new RuntimeException("Not found");
		studen1.setFirstName(student.getFirstName());
		studen1.setLastName(student.getLastName());
		studen1.setBirthdate(student.getBirthdate());
		studen1.setPhone(student.getPhone());
		return studen1;
	}
    
    

}
