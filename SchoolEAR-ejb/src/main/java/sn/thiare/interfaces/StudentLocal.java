package sn.thiare.interfaces;

import java.util.List;

import javax.ejb.Local;

import sn.thiare.entities.Student;

@Local
public interface StudentLocal {

	public Student create(Student year);
	public Student getStudent(int id);
	public List<Student> getAll();
	public void delete(int id);
	public Student update(int id, Student student);
}
