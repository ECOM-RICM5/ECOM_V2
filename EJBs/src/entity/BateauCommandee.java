package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bateau_commandee database table.
 * 
 */
@Entity
@Table(name="bateau_commandee")
@NamedQuery(name="BateauCommandee.findAll", query="SELECT b FROM BateauCommandee b")
public class BateauCommandee implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BateauCommandeePK id;

	private short quantite;

	//bi-directional many-to-one association to Commande
	@ManyToOne
	private Commande commande;

	//bi-directional many-to-one association to Bateau
	@ManyToOne
	private Bateau bateau;

	public BateauCommandee() {
	}

	public BateauCommandeePK getId() {
		return this.id;
	}

	public void setId(BateauCommandeePK id) {
		this.id = id;
	}

	public short getQuantite() {
		return this.quantite;
	}

	public void setQuantite(short quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Bateau getBateau() {
		return this.bateau;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}

}