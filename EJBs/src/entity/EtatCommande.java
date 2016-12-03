package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the etat_commande database table.
 * 
 */
@Entity
@Table(name="etat_commande")
@NamedQuery(name="EtatCommande.findAll", query="SELECT e FROM EtatCommande e")
public class EtatCommande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ETAT_COMMANDE_CODEETAT_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ETAT_COMMANDE_CODEETAT_GENERATOR")
	private int codeEtat;

	private String description;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="etatCommande")
	private List<Commande> commandes;

	public EtatCommande() {
	}

	public int getCodeEtat() {
		return this.codeEtat;
	}

	public void setCodeEtat(int codeEtat) {
		this.codeEtat = codeEtat;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setEtatCommande(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setEtatCommande(null);

		return commande;
	}

}