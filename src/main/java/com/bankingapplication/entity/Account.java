package com.bankingapplication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private  int accountId;
	private String accType;
	private double accBalance;
	private long accountNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Transaction> transaction;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accType=" + accType + ", accBalance=" + accBalance
				+ ", accountNumber=" + accountNumber + ", transaction=" + transaction + "]";
	}
}
