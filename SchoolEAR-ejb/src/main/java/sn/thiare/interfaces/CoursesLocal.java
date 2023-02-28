package sn.thiare.interfaces;

import java.util.List;

import javax.ejb.Local;

import sn.thiare.entities.Courses;

@Local
public interface CoursesLocal {
	
	public Courses create(Courses courses);
	public Courses getCourses(int id);
	public List<Courses> getAll();
	public void delete(int id);
	public Courses update(int id, Courses courses);
}
