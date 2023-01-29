package com.aniket.portal.service;

import com.aniket.portal.pojos.CustomerRegistrationReqPojo;
//import com.aniket.portal.pojos.RegistrationReqPojo;
//import com.aniket.portal.pojos.RegistrationReqPojo;
import com.aniket.portal.pojos.RegistrationRespPojo;

public interface CustomerRegistrationSrvc {

	public Boolean savecustomerdetails(CustomerRegistrationReqPojo regpojo);
	public RegistrationRespPojo customerdetails(CustomerRegistrationReqPojo regpojo);
	public RegistrationRespPojo checkusername(String username);

}
