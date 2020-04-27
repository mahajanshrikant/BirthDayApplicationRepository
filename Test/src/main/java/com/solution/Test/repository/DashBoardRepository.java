package com.solution.Test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solution.Test.model.UserInfo;

@Repository
public interface DashBoardRepository extends JpaRepository<UserInfo,Integer> {
 
	
}
