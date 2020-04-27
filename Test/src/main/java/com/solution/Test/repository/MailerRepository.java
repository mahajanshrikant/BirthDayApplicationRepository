package com.solution.Test.repository;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.stereotype.Repository;

@Repository
public interface MailerRepository {

	public void sendmail() throws IOException, AddressException, MessagingException;
}
