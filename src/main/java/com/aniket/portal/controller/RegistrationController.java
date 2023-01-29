package com.aniket.portal.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aniket.portal.pojos.RegistrationReqPojo;
import com.aniket.portal.pojos.RegistrationRespPojo;
import com.aniket.portal.service.RegistrationSrvc;
import com.aniket.portal.service.CustomerRegistrationSrvc;
import com.aniket.portal.pojos.CustomerRegistrationReqPojo;


@RestController
public class RegistrationController {
	@Autowired
	CustomerRegistrationSrvc customerService;
	@PostMapping("/customerregister")
	public RegistrationRespPojo customerregister(@RequestBody CustomerRegistrationReqPojo regpojo)
	{
		RegistrationRespPojo resppojo = customerService.customerdetails(regpojo);
		return resppojo;
	}
	@PostMapping("/checkusername")
	public RegistrationRespPojo checkusername(@RequestBody String username)
	{
		RegistrationRespPojo resppojo=customerService.checkusername(username);
		return resppojo;
	}
}