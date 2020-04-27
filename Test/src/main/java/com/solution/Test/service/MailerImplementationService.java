package com.solution.Test.service;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

import com.solution.Test.repository.MailerRepository;

@Service
public class MailerImplementationService implements MailerRepository {

	@Override
	public void sendmail() throws IOException, AddressException, MessagingException {
		
		Properties props=new Properties();
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");
		
		Session session =Session.getInstance(props,new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("mahajanshrikant1995@gmail.com","pravin@1995");
			}
		});
		
		Message msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress("mahajanshrikant1995@gmail.com",false));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mahajanshrikant1995@gmail.com"));
		msg.setSubject("HappyWala Birthday Shrikant");
		msg.setContent("Wish you a many many happy return of the day","text/html");
		msg.setSentDate(new Date());
		
		MimeBodyPart messageBodyPart=new MimeBodyPart();
		messageBodyPart.setContent("wish you many many happy return of the day","text/html");
		
		Multipart multipart=new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		
		msg.setContent(multipart);
		Transport.send(msg);
	}
}
