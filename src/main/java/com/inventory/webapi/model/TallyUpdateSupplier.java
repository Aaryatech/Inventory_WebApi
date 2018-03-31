package com.inventory.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supplier")
public class TallyUpdateSupplier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "supp_id")
	private int suppId; 
	
	@Column(name = "is_tally_sync")
	private int isTallySync;

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	@Override
	public String toString() {
		return "TallyUpdateSupplier [suppId=" + suppId + ", isTallySync=" + isTallySync + "]";
	}

	
	
}
