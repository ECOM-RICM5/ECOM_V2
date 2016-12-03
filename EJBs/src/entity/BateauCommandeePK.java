package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the bateau_commandee database table.
 * 
 */
@Embeddable
public class BateauCommandeePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="commande_id", insertable=false, updatable=false)
	private int commandeId;

	@Column(name="bateau_id", insertable=false, updatable=false)
	private int bateauId;

	public BateauCommandeePK() {
	}
	public int getCommandeId() {
		return this.commandeId;
	}
	public void setCommandeId(int commandeId) {
		this.commandeId = commandeId;
	}
	public int getBateauId() {
		return this.bateauId;
	}
	public void setBateauId(int bateauId) {
		this.bateauId = bateauId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BateauCommandeePK)) {
			return false;
		}
		BateauCommandeePK castOther = (BateauCommandeePK)other;
		return 
			(this.commandeId == castOther.commandeId)
			&& (this.bateauId == castOther.bateauId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.commandeId;
		hash = hash * prime + this.bateauId;
		
		return hash;
	}
}