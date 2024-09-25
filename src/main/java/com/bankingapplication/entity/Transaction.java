package com.bankingapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
     
	   @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int transactionId;
	   private String type;
	   private  double transactionAmount;
	   private String status;
	   private int customerId;
	  public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	 @Override
		public String toString() {
			return "Transaction [transactionId=" + transactionId + ", type=" + type + ", transactionAmount="
					+ transactionAmount + ", status=" + status + ", customerId=" + customerId + "]";
		}
	
	
	
	
	
	
	
	
	
	
}
