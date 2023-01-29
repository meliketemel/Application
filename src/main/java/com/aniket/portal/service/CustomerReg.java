package com.aniket.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniket.portal.model.CustomersDetailsModel;
import com.aniket.portal.model.BusRoutesModel;
//import com.aniket.portal.pojos.RegistrationReqPojo;
import com.aniket.portal.pojos.CustomerRegistrationReqPojo;
import com.aniket.portal.pojos.RegistrationReqPojo;
import com.aniket.portal.pojos.RegistrationRespPojo;
//import com.aniket.portal.repository.BusDetailsRepo;
import com.aniket.portal.repository.BusRouteRepo;
import com.aniket.portal.repository.CustomersDetailsRepo;

@Service
public class CustomerReg implements CustomerRegistrationSrvc  {

	@Autowired
	CustomersDetailsRepo regrepo;
	@Autowired
	BusRouteRepo routerepo;
	@Override
	public Boolean savecustomerdetails(CustomerRegistrationReqPojo regpojo) {
		Long id1=0L;
		try
		{
			CustomersDetailsModel regobj1=new CustomersDetailsModel();
			regobj1.setCustomername(regpojo.getCustomername());
			regobj1.setCustomersurname(regpojo.getCustomerSurname());
			regobj1.setEmailid(regpojo.getEmailid());
			regobj1.setMobileno(regpojo.getMobileno());
			regobj1.setTcno(regpojo.getTcno());
			
			if(regrepo.count()==0)
			{
				id1=1L;
			}
			else
			{
				id1=regrepo.fetchmaxid()+1;
			}
			regobj1.setId(id1);
			regrepo.save(regobj1);
			int size1=regpojo.getLisstoppages().size();
			for(int i=0;i<size1;i++)
			{
				BusRoutesModel routeobj=new BusRoutesModel();
				if(routerepo.count()==0)
				{
					routeobj.setId(1L);
				}
				else
				{
					routeobj.setId(routerepo.fetchmaxid()+1);
				}
				routeobj.setBusdtlsid(id1);
				routeobj.setLocationname(regpojo.getLisstoppages().get(i));
				routeobj.setOrderid(i+1);
				routerepo.save(routeobj);
			}
			return true;
		}
		catch(Exception e)
		{
			regrepo.deleteById(id1);
			routerepo.deletefailedcase(id1);
			return false;
		}
	}
	
	@Override
	public RegistrationRespPojo customerdetails(CustomerRegistrationReqPojo regpojo) {
		// TODO Auto-generated method stub
		RegistrationRespPojo resppojo1=new RegistrationRespPojo();
		if(regrepo.fetchuserid(regpojo.getTcno())==null)
		{
			Boolean result=savecustomerdetails(regpojo);
			if(result==true)
			{
				resppojo1.setStatus("Success");
				resppojo1.setMessage("Customer Registered with TC "+regpojo.getTcno());
			}
			else
			{
				resppojo1.setStatus("Failed");
				resppojo1.setMessage("Customer Registration Failed. Please try again later");
			}
		}
		else
		{
			resppojo1.setStatus("Failed");
			resppojo1.setMessage("Customer Already Exists");
		}
		return resppojo1;
	}
	@Override
	public RegistrationRespPojo checkusername(String username) {
		// TODO Auto-generated method stub
		RegistrationRespPojo resppojo1=new RegistrationRespPojo();
		if(regrepo.fetchuserid(username)==null)
		{
			resppojo1.setStatus("Success");
			resppojo1.setMessage("Valid UserID");
		}
		else
		{
			resppojo1.setStatus("Failed");
			resppojo1.setMessage("Username Already Exists");
		}
		return resppojo1;
	}
}
