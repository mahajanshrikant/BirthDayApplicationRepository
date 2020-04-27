package com.solution.Test.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.solution.Test.model.UserInfo;

@Repository
public interface getUserRepository extends JpaRepository<UserInfo,Integer> {

	@Query("select t from UserInfo t where t.dateofbirth=?1")
	List<UserInfo> getUserByDateofBirth(String currentdate);
	
	
	
}
