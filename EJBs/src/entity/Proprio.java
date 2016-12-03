package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proprio database table.
 * 
 */
@Entity
@Table(name="proprio")
@NamedQuery(name="Proprio.findAll", query="SELECT p FROM Proprio p")
public class Proprio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROPRIO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROPRIO_ID_GENERATOR")
	private int id;

	private String email;

	private String nom;

	private String prenom;

	private String telephone;

	//bi-directional many-to-many association to Bateau
	@ManyToMany
	@JoinTable(
		name="proprio_bateau"
		, joinColumns={
			@JoinColumn(name="proprio_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="bateau_id")
			}
		)
	private List<Bateau> bateaus;

	public Proprio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Bateau> getBateaus() {
		return this.bateaus;
	}

	public void setBateaus(List<Bateau> bateaus) {
		this.bateaus = bateaus;
	}

}