package sn.thiare.interfaces;

import java.util.List;

import javax.ejb.Remote;

import sn.thiare.entities.Student;

@Remote
public interface StudentRemote {

	public Student create(Student year);
	public Student getStudent(int id);
	public List<Student> getAll();
	public void delete(int id);
	public Student update(int id, Student student);
}
