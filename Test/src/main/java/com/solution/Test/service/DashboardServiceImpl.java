package com.solution.Test.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solution.Test.model.Mail;
import com.solution.Test.model.UserInfo;
import com.solution.Test.repository.DashBoardRepository;

@Service
public class DashboardServiceImpl implements DashBoardServie {

	@Autowired
	DashBoardRepository dashBoardRepository;
	
	@Autowired
	MailerImplementationService mailerImplementationService;
	
	@Autowired
	MailServiceImpl mailServiceImpl;
	
	
	
	
	
	@Override
	public List<UserInfo> getalluser() throws AddressException, IOException, MessagingException {
		List<UserInfo> userdata=dashBoardRepository.findAll();
		Map<String ,String> map=new HashMap<>();
		for(UserInfo stu:userdata) {
		map.put(stu.getDateofbirth(),stu.getEmailid());
		}
		for(Map.Entry<String, String> entry:map.entrySet()) {
			System.out.println("key"+entry.getKey() +"value" +entry.getValue());
			DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String dateofbirth=entry.getKey();
			String mailemailid=entry.getValue();
			
			Date date=new Date();
			String todayDate=dateFormat.format(date);
			if(dateofbirth.equals(todayDate)) {
				Mail mail = new Mail();
		        mail.setMailFrom("Your mail Address");
	        mail.setMailTo(mailemailid);
	        mail.setMailSubject("Many many Happy Returns of the Day");
	        mail.setMailContent(" Wishing you the health,love,waelth,happiness,...........");
				mailServiceImpl.sendEmail(mail);
				
//					mailerImplementationService.sendmail();
				
				System.out.println("new date"+dateofbirth);
				
			}else {
				System.out.println("date are not equals");
			}
		}
		
		

	return userdata;
	
	}





	

}
