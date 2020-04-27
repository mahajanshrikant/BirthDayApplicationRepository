package com.solution.Test.service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.stereotype.Service;

import com.solution.Test.model.UserInfo;
@Service
public interface DashBoardServie {
	
	List<UserInfo> getalluser() throws AddressException, IOException, MessagingException;

}
