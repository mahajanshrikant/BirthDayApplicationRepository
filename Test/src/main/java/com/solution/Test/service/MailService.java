package com.solution.Test.service;

import org.springframework.stereotype.Service;

import com.solution.Test.model.Mail;

public interface MailService {
	
	public void sendEmail(Mail mail);
}
