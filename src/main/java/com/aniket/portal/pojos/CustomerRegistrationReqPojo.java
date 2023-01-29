package com.aniket.portal.pojos;

import java.util.List;

public class CustomerRegistrationReqPojo {

	private String customername; 
	private String customersurname; 
	private String mobileno; 
	private String emailid; 
	private String tcno; 
	private List<String> lisstoppages;
	
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomerSurname() {
		return customersurname;
	}
	public void setCustomerSurname(String customersurname) {
		this.customersurname = customersurname;
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
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	
	public List<String> getLisstoppages() {
		return lisstoppages;
	}
	public void setLisstoppages(List<String> lisstoppages) {
		this.lisstoppages = lisstoppages;
	}
	
	@Override
	public String toString() {
		return "RegistrationReqPojo [ customername=" + customername
				+ ", customersurname=" + customersurname + ", mobileno=" + mobileno + ", emailid=" + emailid + ", tcno="
				+ tcno + "]";
	}
}
