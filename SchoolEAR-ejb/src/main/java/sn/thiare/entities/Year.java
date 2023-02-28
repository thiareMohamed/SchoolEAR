package sn.thiare.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Year
 *
 */
@Entity

public class Year implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "year")
	private List<Inscription> inscription;
	private static final long serialVersionUID = 1L;

	public Year() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<Inscription> getInscription() {
		return inscription;
	}
	public void setInscription(List<Inscription> inscription) {
		this.inscription = inscription;
	}
   
}
