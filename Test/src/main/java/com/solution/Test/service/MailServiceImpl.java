package com.solution.Test.service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.solution.Test.model.Mail;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
    JavaMailSender mailSender;
	
	@Override
	public void sendEmail(Mail mail) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		 try {
			 
	            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED,StandardCharsets.UTF_8.name());
	            
	            mimeMessageHelper.addAttachment("logo.png", new ClassPathResource("memorynotfound-logo.png"));
	            String inlineImage="<img src=\"cid:logo.png\"></img><br/>";
	            mimeMessageHelper.setText(inlineImage +mail.getMailContent(),true);
	            mimeMessageHelper.setSubject(mail.getMailSubject());
	            mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(), "yourmail addresss"));
	            mimeMessageHelper.setTo(mail.getMailTo());
//               mimeMessageHelper.setText(mail.getMailContent());
	 
	            mailSender.send(mimeMessageHelper.getMimeMessage());
	 
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	    }
	}


