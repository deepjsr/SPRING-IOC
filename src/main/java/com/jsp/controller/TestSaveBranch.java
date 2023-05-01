package com.jsp.controller;

import java.nio.channels.AcceptPendingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.jsp.dto.Branch;
import com.jsp.service.BranchService;
import com.jsp.util.Config;

public class TestSaveBranch {
	public static void main(String[] args) {
		Branch branch = new Branch();
		branch.setId(1);
		branch.setAddress("dharavi");
		branch.setPhone(8875447561l);
		branch.setweb("mbranch.com");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		BranchService service = (BranchService) applicationContext.getBean("BranchService");
		Branch branch2=service.savebranch(branch);
		if (branch2!=null) {	
			System.out.println("Data saved");
		}
		else
			System.out.println("Check the id.....");
	}
}
