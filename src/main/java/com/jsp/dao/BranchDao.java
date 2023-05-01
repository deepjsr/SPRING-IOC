package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Branch;


public class BranchDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("god");

	public Branch saveBranch(Branch branch) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entTransaction = entityManager.getTransaction();
		if (branch != null) {
			entTransaction.begin();
			entityManager.persist(branch);
			entTransaction.commit();
		}
		return branch;
	}

	public Branch updateBranch(Branch Branch) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entTransaction = entityManager.getTransaction();
		Branch Branch2 = entityManager.find(Branch.class, Branch.getId());
		if (Branch2 != null) {
			entTransaction.begin();
			entityManager.merge(Branch);
			entTransaction.commit();
		} else {
			BranchDao dao = new BranchDao();
			dao.saveBranch(Branch);
			System.out.println("Branch saved");
		}

		return Branch;
	}

	public Branch deleteBranch(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entTransaction = entityManager.getTransaction();
		Branch Branch = entityManager.find(Branch.class, id);
		if (Branch != null) {
			entTransaction.begin();
			entityManager.remove(Branch);
			entTransaction.commit();
		}
		return Branch;
	}

	public Branch getBranchById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		return entityManager.find(Branch.class, id);
	}

	public List<Branch> getAllBranch() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery(" select a from Branch a ");
		return query.getResultList();
	}

	public Branch loginBranch(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery(" select a from Branch a where email= ?1 and password= ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);

		List<Branch> list = query.getResultList();
		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}
}
