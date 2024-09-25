package com.bankingapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bankingapplication.entity.Account;

public class AccountDao {
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();

	    public Account saveAccount(Account account) {
	        et.begin();
	        em.persist(account);
	        et.commit();
	        return account;
	    }
	    
	    public Account findAccount(int accountId) {
	        Account account = em.find(Account.class, accountId);
	        return account;
	    }

	    public Account deleteAccount(int accountId) {
	        Account account = em.find(Account.class, accountId);
	        if (account != null) {
	            et.begin();
	            em.remove(account);
	            et.commit();
	            return account;
	        }
	        return null;
	    }

	    public Account updateAccount(Account account, int accountId) {
	        Account dbAccount = em.find(Account.class, accountId);
	        if (dbAccount != null) {
	            account.setAccountId(accountId);
	            et.begin();
	            em.merge(account);
	            et.commit();
	            return account;
	        }
	        return null;
	    }

	    public List<Account> getAllAccounts() {
	        Query query =em.createQuery("SELECT a FROM Account a");//java.persistence
	        List<Account> allAccounts = query.getResultList();
	        return allAccounts;
	    }
}
