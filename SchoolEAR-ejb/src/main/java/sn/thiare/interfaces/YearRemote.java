package sn.thiare.interfaces;

import java.util.List;

import javax.ejb.Remote;

import sn.thiare.entities.Year;

@Remote
public interface YearRemote {


	public Year create(Year year);
	public Year getYear(int id);
	public List<Year> getAll();
	public void delete(int id);
	public Year update(int id, Year year);
}
