package sn.thiare.interfaces;

import java.util.List;

import javax.ejb.Local;

import sn.thiare.entities.Inscription;

@Local
public interface InscriptionLocal {

	public Inscription create(Inscription inscription);
	public Inscription getInscription(int id);
	public List<Inscription> getAll();
	public void delete(int id);
	public Inscription update(int id, Inscription inscription);
	public List<Inscription> getAllByStudentId(int id);
}
