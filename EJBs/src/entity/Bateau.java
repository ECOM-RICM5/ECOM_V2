package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the bateau database table.
 * 
 */
@Entity
@Table(name="bateau")
@NamedQueries({@NamedQuery(name = "Product.findAll", query = "select o from Bateau o"), @NamedQuery(name = "Product.findByProductId", query = "select o from Bateau o where o.id = :productId"), @NamedQuery(name = "Product.findByCategoryId", query = "select o from Bateau o where o.categorie.id = :categoryId")})
public class Bateau implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BATEAU_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BATEAU_ID_GENERATOR")
	private int id;

	private String description;
	
	//@Column(nullable = false, columnDefinition = "TINYINT(1)")
	 @Basic 
	private int disponibilite;

	private String nom;

	private BigDecimal prix;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	private Categorie categorie;

	//bi-directional many-to-one association to BateauCommandee
	@OneToMany(mappedBy="bateau")
	private List<BateauCommandee> bateauCommandees;

	//bi-directional many-to-many association to Proprio
	@ManyToMany(mappedBy="bateaus")
	private List<Proprio> proprios;

	public Bateau() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDisponibilite() {
		return this.disponibilite;
	}

	public void setDisponibilite(int disponibilite) {
		this.disponibilite = disponibilite;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<BateauCommandee> getBateauCommandees() {
		return this.bateauCommandees;
	}

	public void setBateauCommandees(List<BateauCommandee> bateauCommandees) {
		this.bateauCommandees = bateauCommandees;
	}

	public BateauCommandee addBateauCommandee(BateauCommandee bateauCommandee) {
		getBateauCommandees().add(bateauCommandee);
		bateauCommandee.setBateau(this);

		return bateauCommandee;
	}

	public BateauCommandee removeBateauCommandee(BateauCommandee bateauCommandee) {
		getBateauCommandees().remove(bateauCommandee);
		bateauCommandee.setBateau(null);

		return bateauCommandee;
	}

	public List<Proprio> getProprios() {
		return this.proprios;
	}

	public void setProprios(List<Proprio> proprios) {
		this.proprios = proprios;
	}

}