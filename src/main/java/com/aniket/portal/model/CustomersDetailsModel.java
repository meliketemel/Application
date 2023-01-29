package com.aniket.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cstmrs_dtls_mstr")
public class CustomersDetailsModel {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "Customer_Name", nullable = false)
	private String customername;
	
	@Column(name = "Customer_Surname", nullable = false)
	private String customersurname;
	
	@Column(name = "TC_No", nullable = false)
	private String tcno;
	
	@Column(name = "Mobile_No", nullable = false)
	private String mobileno;
	
	@Column(name = "Emailid")
	private String emailid;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	public String getCustomersurname() {
		return customersurname;
	}

	public void setCustomersurname(String customersurname) {
		this.customersurname = customersurname;
	}
	
	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	

}
