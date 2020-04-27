package com.solution.Test.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="userinfo")
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	public int userid;
	
	@Column(name="username")
	public String username;
	
	@Column(name="gender")
	public String gender;
	
	@Column(name="dateofbirth")
	public String dateofbirth;
	
	@Column(name="emailid")
	public String  emailid;
	
	@Column(name="currentdate")
	public String  currentdate;
	
	public UserInfo() {
		
		
	}

	public String getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(String currentdate) {
		
		this.currentdate = currentdate;
	}





	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", username=" + username + ", gender=" + gender + ", dateofbirth="
				+ dateofbirth + ", emailid=" + emailid + "]";
	}
}
