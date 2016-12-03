package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the commande database table.
 * 
 */
@Entity
@Table(name="commande")
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMMANDE_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMMANDE_ID_GENERATOR")
	private int id;

	@Column(name="date_commande")
	private Timestamp dateCommande;

	@Column(name="numero_confirmation")
	private int numeroConfirmation;

	private BigDecimal quantite;

	//bi-directional many-to-one association to BateauCommandee
	@OneToMany(mappedBy="commande")
	private List<BateauCommandee> bateauCommandees;

	//bi-directional many-to-one association to Client
	@ManyToOne
	private Client client;

	//bi-directional many-to-one association to EtatCommande
	@ManyToOne
	@JoinColumn(name="etat_commande_codeEtat")
	private EtatCommande etatCommande;

	public Commande() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(Timestamp dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getNumeroConfirmation() {
		return this.numeroConfirmation;
	}

	public void setNumeroConfirmation(int numeroConfirmation) {
		this.numeroConfirmation = numeroConfirmation;
	}

	public BigDecimal getQuantite() {
		return this.quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public List<BateauCommandee> getBateauCommandees() {
		return this.bateauCommandees;
	}

	public void setBateauCommandees(List<BateauCommandee> bateauCommandees) {
		this.bateauCommandees = bateauCommandees;
	}

	public BateauCommandee addBateauCommandee(BateauCommandee bateauCommandee) {
		getBateauCommandees().add(bateauCommandee);
		bateauCommandee.setCommande(this);

		return bateauCommandee;
	}

	public BateauCommandee removeBateauCommandee(BateauCommandee bateauCommandee) {
		getBateauCommandees().remove(bateauCommandee);
		bateauCommandee.setCommande(null);

		return bateauCommandee;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public EtatCommande getEtatCommande() {
		return this.etatCommande;
	}

	public void setEtatCommande(EtatCommande etatCommande) {
		this.etatCommande = etatCommande;
	}

}