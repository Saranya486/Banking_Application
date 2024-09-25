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
public class Bank{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankId;
	private String bankName;
	private String ifsc;
	private String city;
    private long contact;
    @OneToOne(cascade = CascadeType.ALL)
    private Manager manager;
	@OneToMany(cascade = CascadeType.ALL)
    private List<Customer> customer;
	 public Manager getManager() {
			return manager;
		}
		public void setManager(Manager manager) {
			this.manager = manager;
		}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", ifsc=" + ifsc + ", city=" + city + ", contact="
				+ contact + ", manager=" + manager + ", customer=" + customer + "]";
	}

	

}
