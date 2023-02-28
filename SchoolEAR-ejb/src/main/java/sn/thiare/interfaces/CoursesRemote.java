package sn.thiare.interfaces;

import java.util.List;

import javax.ejb.Remote;

import sn.thiare.entities.Courses;

@Remote
public interface CoursesRemote {

	public Courses create(Courses courses);
	public Courses getCourses(int id);
	public List<Courses> getAll();
	public void delete(int id);
	public Courses update(int id, Courses courses);
}
