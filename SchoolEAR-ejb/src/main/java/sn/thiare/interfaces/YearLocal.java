package sn.thiare.interfaces;

import java.util.List;

import javax.ejb.Local;

import sn.thiare.entities.Year;

@Local
public interface YearLocal {

	public Year create(Year year);
	public Year getYear(int id);
	public List<Year> getAll();
	public void delete(int id);
	public Year update(int id, Year year);
}
