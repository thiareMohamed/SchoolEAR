package sn.thiare.interfaces;

import java.util.List;

import javax.ejb.Remote;

import sn.thiare.entities.Inscription;

@Remote
public interface InscriptionRemote {

	public Inscription create(Inscription inscription);
	public Inscription getInscription(int id);
	public List<Inscription> getAll();
	public void delete(int id);
	public Inscription update(int id, Inscription inscription);
}
