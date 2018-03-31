package com.inventory.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;

@Entity
@Table(name="supplier")
public class TallySupplier implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "supp_id")
	private int suppId; 
	
	@Column(name = "supp_name")
	private String supplierName;

	@Column(name = "address")
	private String address;
	
	@Column(name = "gstin_no")
	private String gstIn;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state; 
	
	@Column(name = "country")
	private String country;

	@Column(name = "mobile1")
	private String mobile1;
	
	@Column(name = "mobile2")
	private String mobile2;
	
	@Column(name = "mobile3")
	private String mobile3;
	
	@Column(name = "phone1")
	private String phone1;
	
	@Column(name = "phone2")
	private String phone2;
	
	@Column(name = "email1")
	private String email1;
	
	@Column(name = "email2")
	private String email2;
	
	@Column(name = "email3")
	private String email3;
	
	@Column(name = "email4")
	private String email4;
	
	@Column(name = "email5")
	private String email5;
	
	@Column(name = "pan_no")
	private String panNo;
	
	@Column(name = "contact_prsn")
	private String contactPrsn;
	
	@Column(name = "fda_lic")
	private String fdaLic;
	
	@Column(name = "supplier_pay_id")
	private String supplierPayId;
	
	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "credit_days")
	private int creditDays;
	
	@Column(name = "is_same_state")
	private String isSameState;
	
	@Column(name = "is_tally_sync")
	private int isTallySync;

	@PostLoad
	public void onLoad() {
		if(isSameState.equalsIgnoreCase("1"))
		{
			this.isSameState="YES";
		}else 
		{
			this.isSameState="No";
		}
	}
	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    
	public String getGstIn() {
		return gstIn;
	}
	public void setGstIn(String gstIn) {
		this.gstIn = gstIn;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getMobile3() {
		return mobile3;
	}

	public void setMobile3(String mobile3) {
		this.mobile3 = mobile3;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getEmail4() {
		return email4;
	}

	public void setEmail4(String email4) {
		this.email4 = email4;
	}

	public String getEmail5() {
		return email5;
	}

	public void setEmail5(String email5) {
		this.email5 = email5;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getContactPrsn() {
		return contactPrsn;
	}

	public void setContactPrsn(String contactPrsn) {
		this.contactPrsn = contactPrsn;
	}

	public String getFdaLic() {
		return fdaLic;
	}

	public void setFdaLic(String fdaLic) {
		this.fdaLic = fdaLic;
	}

	public String getSupplierPayId() {
		return supplierPayId;
	}

	public void setSupplierPayId(String supplierPayId) {
		this.supplierPayId = supplierPayId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getCreditDays() {
		return creditDays;
	}

	public void setCreditDays(int creditDays) {
		this.creditDays = creditDays;
	}

	public String getIsSameState() {
		return isSameState;
	}

	public void setIsSameState(String isSameState) {
		this.isSameState = isSameState;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	@Override
	public String toString() {
		return "TallySupplier [suppId=" + suppId + ", supplierName=" + supplierName + ", address=" + address
				+ ", gstinNo=" + gstIn + ", city=" + city + ", state=" + state + ", country=" + country + ", mobile1="
				+ mobile1 + ", mobile2=" + mobile2 + ", mobile3=" + mobile3 + ", phone1=" + phone1 + ", phone2="
				+ phone2 + ", email1=" + email1 + ", email2=" + email2 + ", email3=" + email3 + ", email4=" + email4
				+ ", email5=" + email5 + ", panNo=" + panNo + ", contactPrsn=" + contactPrsn + ", fdaLic=" + fdaLic
				+ ", supplierPayId=" + supplierPayId + ", delStatus=" + delStatus + ", creditDays=" + creditDays
				+ ", isSameState=" + isSameState + ", isTallySync=" + isTallySync + "]";
	}
	
}
