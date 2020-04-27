package com.solution.Test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solution.Test.model.Mail;
import com.solution.Test.model.UserInfo;
import com.solution.Test.repository.UserRepository;
import com.solution.Test.repository.getUserRepository;
import com.solution.Test.service.DashBoardServie;
import com.solution.Test.service.MailService;

@RestController
public class MailController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	getUserRepository  getuserRepository;
	
	@Autowired
	DashBoardServie dashBoardServie;
		
	
	
	@RequestMapping(value="/getalluser1",method=RequestMethod.GET,headers="Accept=application/json")
	public List<UserInfo> getalluser1() throws AddressException, IOException, MessagingException {
		return dashBoardServie.getalluser();
	
	}
	
	
	@RequestMapping(value="/getalluser",method=RequestMethod.GET,headers="Accept=application/json")
	public List<UserInfo> getalluser() {
		List<UserInfo> userdata=userRepository.findAll();
		List<UserInfo> useadd=new ArrayList<>();
		
		for(int i=0;i<userdata.size();i++) {
			useadd.addAll(userdata);
		}
		
		
		return userdata;
	}
	
	@RequestMapping(value="/getalluserbydateofbirth",method=RequestMethod.POST,headers="Accept=application/json")
	public List<UserInfo> getalluser1(@RequestParam("currentdate") String currentdate) {
		return getuserRepository.getUserByDateofBirth(currentdate);
	
	}
	
}
