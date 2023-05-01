package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.dao.BranchDao;
import com.jsp.dto.Branch;
@Service("BranchService")
public class BranchService {
	BranchDao dao = new BranchDao();

	@Autowired
	 public Branch savebranch(Branch branch) {
			return dao.saveBranch(branch);
		}
	 public Branch updatebranch(Branch branch) {
		 return dao.updateBranch(branch);
	 }
	 public Branch deletebranch(int	id) {
		 return dao.deleteBranch(id);
	 }
	 public Branch getbranchById(int id) {
		 return dao.getBranchById(id);
	 }
	 public List<Branch> getAllbranch() {
		 return dao.getAllBranch();
	 }
	 public Branch loginbranch(String password , String username) {
		 return dao.loginBranch( password ,  username);
	 }

}
