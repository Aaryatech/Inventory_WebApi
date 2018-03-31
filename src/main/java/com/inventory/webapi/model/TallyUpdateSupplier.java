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
	
	@Column(name = "in1")
	private int in1;

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public int getIn1() {
		return in1;
	}

	public void setIn1(int in1) {
		this.in1 = in1;
	}

	@Override
	public String toString() {
		return "TallyUpdateSupplier [suppId=" + suppId + ", in1=" + in1 + "]";
	}
	
	
}
