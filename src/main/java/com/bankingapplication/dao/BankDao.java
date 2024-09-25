package com.bankingapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bankingapplication.entity.Bank;

public class BankDao {
	
	
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();

	    public Bank saveBank(Bank bank) {
	        et.begin();
	        em.persist(bank);
	        et.commit();
	        return bank;
	    }

	    public Bank findBank(int bankId) {
	        Bank bank = em.find(Bank.class, bankId);
	        return bank;
	    }

	    public Bank deleteBank(int bankId) {
	        Bank bank = em.find(Bank.class, bankId);
	        if (bank != null) {
	            et.begin();
	            em.remove(bank);
	            et.commit();
	            return bank;
	        }
	        return null;
	    }

	    public Bank updateBank(Bank bank, int bankId) {
	        Bank dbBank = em.find(Bank.class, bankId);
	        if (dbBank != null) {
	            bank.setBankId(bankId);
	            et.begin();
	            em.merge(bank);
	            et.commit();
	            return bank;
	        }
	        return null;
	    }

	    public List<Bank> getAllBanks() {
	        Query query = em.createQuery("SELECT b FROM Bank b");
	        List<Bank> allBanks = query.getResultList();
	        return allBanks;
	    }

}
