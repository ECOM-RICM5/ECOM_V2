package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie database table.
 * 
 */
@Entity
@Table(name="categorie")
@NamedQueries({@NamedQuery(name = "Category.findAll", query = "select o from Categorie o"), @NamedQuery(name = "Category.findByCategoryName", query = "select o from Categorie o where o.nom = :categoryName")})
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATEGORIE_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORIE_ID_GENERATOR")
	private byte id;

	private String description;

	private String nom;

	//bi-directional many-to-one association to Bateau
	@OneToMany(mappedBy="categorie")
	private List<Bateau> bateaus;

	public Categorie() {
	}

	public byte getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Bateau> getBateaus() {
		return this.bateaus;
	}

	public void setBateaus(List<Bateau> bateaus) {
		this.bateaus = bateaus;
	}

	public Bateau addBateaus(Bateau bateaus) {
		getBateaus().add(bateaus);
		bateaus.setCategorie(this);

		return bateaus;
	}

	public Bateau removeBateaus(Bateau bateaus) {
		getBateaus().remove(bateaus);
		bateaus.setCategorie(null);

		return bateaus;
	}

}