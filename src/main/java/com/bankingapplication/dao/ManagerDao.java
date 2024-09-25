package com.bankingapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bankingapplication.entity.Manager;

public class ManagerDao {
	
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
	 EntityManager em = emf.createEntityManager();
	 EntityTransaction et = em.getTransaction();
	    
	    public Manager saveManager(Manager manager) {
	        et.begin();
	        em.persist(manager);
	        et.commit();
	        return manager;
	    }

	    public Manager findManager(int managerId) {
	        Manager manager = em.find(Manager.class, managerId);
	        return manager;
	    }
	    public Manager deleteManager(int managerId) {
	        Manager manager = em.find(Manager.class, managerId);
	        if (manager != null) {
	            et.begin();
	            em.remove(manager);
	            et.commit();
	            return manager;
	        }
	        return null;
	    }

	    public Manager updateManager(Manager manager, int managerId) {
	        Manager dbManager = em.find(Manager.class, managerId);
	        if (dbManager != null) {
	            manager.setManagerId(managerId);
	            et.begin();
	            em.merge(manager);
	            et.commit();
	            return manager;
	        }
	        return null;
	    }
	    public List<Manager> getAllManagers() {
	        Query query = em.createQuery("SELECT m FROM Manager m");
	        List<Manager> allManagers = query.getResultList();
	        return allManagers;
	    }

}
