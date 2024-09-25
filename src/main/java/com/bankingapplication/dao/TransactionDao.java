package com.bankingapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bankingapplication.entity.Transaction;

public class TransactionDao {
	
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();

	    public Transaction saveTransaction(Transaction transaction) {
	        et.begin();
	        em.persist(transaction);
	        et.commit();
	        return transaction;
	    }

	    public Transaction findTransaction(int transactionId) {
	        Transaction transaction = em.find(Transaction.class, transactionId);
	        return transaction;
	    }

	    public Transaction deleteTransaction(int transactionId) {
	        Transaction transaction = em.find(Transaction.class, transactionId);
	        if (transaction != null) {
	            et.begin();
	            em.remove(transaction);
	            et.commit();
	            return transaction;
	        }
	        return null;
	    }

	    public Transaction updateTransaction(Transaction transaction, int transactionId) {
	        Transaction dbTransaction = em.find(Transaction.class, transactionId);
	        if (dbTransaction != null) {
	            transaction.setTransactionId(transactionId);
	            et.begin();
	            em.merge(transaction);
	            et.commit();
	            return transaction;
	        }
	        return null;
	    }

	    public List<Transaction> getAllTransactions() {
	        Query query = em.createQuery("SELECT t FROM Transaction t");
	        List<Transaction> allTransactions = query.getResultList();
	        return allTransactions;
	    }

}
