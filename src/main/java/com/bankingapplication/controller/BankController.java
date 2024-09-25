package com.bankingapplication.controller;

import java.util.List;
import java.util.Scanner;

import com.bankingapplication.dao.AccountDao;
import com.bankingapplication.dao.BankDao;
import com.bankingapplication.dao.CustomerDao;
import com.bankingapplication.dao.ManagerDao;
import com.bankingapplication.dao.TransactionDao;
import com.bankingapplication.entity.Account;
import com.bankingapplication.entity.Bank;
import com.bankingapplication.entity.Customer;
import com.bankingapplication.entity.Manager;
import com.bankingapplication.entity.Transaction;

public class BankController {
	
	
	 Scanner sc = new Scanner(System.in);

	    BankDao bankDao= new BankDao();
	    CustomerDao customerDao = new CustomerDao();
	    ManagerDao managerDao = new ManagerDao();
	    AccountDao accountDao = new AccountDao();
	    TransactionDao transactionDao = new TransactionDao();

	    public void saveBank() {
	        Bank bank = new Bank();
	        System.out.println("Enter bank name:");
	        bank.setBankName(sc.next());
	        System.out.println("Enter bank IFSC:");
	        bank.setIfsc(sc.next());
	        System.out.println("Enter bank city:");
	        bank.setCity(sc.next());
	        System.out.println("Enter bank contact number:");
	        bank.setContact(sc.nextLong());

	        // Assuming you have a method to save a manager for the bank
	        System.out.println("Enter manager details for the bank:");
	        Manager manager = new Manager();
	        System.out.println("Enter manager name:");
	        manager.setManagerName(sc.next());
	        System.out.println("Enter manager city:");
	        manager.setCity(sc.next());
	        System.out.println("Enter manager contact number:");
	        manager.setContact(sc.nextLong());
	        bank.setManager(manager);
	        manager.setBank(bank);

	        if (bankDao.saveBank(bank) != null) {
	            System.out.println("Bank saved successfully");
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void findAllBanks() {
	        List<Bank> allBanks = bankDao.getAllBanks();
	        for (Bank bank : allBanks) {
	            System.out.println(bank.getBankId() + " " + bank.getBankName() + " " + bank.getCity());
	        }
	    }

	    public void findBank() {
	        System.out.println("Enter bank ID:");
	        int id = sc.nextInt();
	        Bank bank = bankDao.findBank(id);
	        if (bank != null) {
	            System.out.println(bank.getBankId() + " " + bank.getBankName() + " " + bank.getCity());
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void updateBank() {
	        System.out.println("Enter bank ID:");
	        int id = sc.nextInt();
	        Bank bank = bankDao.findBank(id);
	        if (bank != null) {
	            System.out.println("1: Update name");
	            System.out.println("2: Update IFSC");
	            System.out.println("3: Update city");
	            System.out.println("4: Update contact");
	            int choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.println("Enter new name:");
	                    bank.setBankName(sc.next());
	                    break;
	                case 2:
	                    System.out.println("Enter new IFSC:");
	                    bank.setIfsc(sc.next());
	                    break;
	                case 3:
	                    System.out.println("Enter new city:");
	                    bank.setCity(sc.next());
	                    break;
	                case 4:
	                    System.out.println("Enter new contact:");
	                    bank.setContact(sc.nextLong());
	                    break;
	                default:
	                    System.out.println("Invalid choice");
	                    return;
	            }
	            bankDao.updateBank(bank, id);
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void deleteBank() {
	        System.out.println("Enter bank ID:");
	        int id = sc.nextInt();
	        if (bankDao.deleteBank(id) != null) {
	            System.out.println("Bank deleted successfully");
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void saveCustomer() {
	        Customer customer = new Customer();
	        System.out.println("Enter customer name:");
	        customer.setName(sc.next());
	        System.out.println("Enter customer city:");
	        customer.setCity(sc.next());
	        System.out.println("Enter customer contact number:");
	        customer.setContact(sc.nextLong());

	        // Assuming you have a method to create an account for the customer
	        System.out.println("Enter account details for the customer:");
	        Account account = new Account();
	        System.out.println("Enter account type:");
	        account.setAccType(sc.next());
	        System.out.println("Enter account balance:");
	        account.setAccBalance(sc.nextDouble());
	        System.out.println("Enter account number:");
	        account.setAccountNumber(sc.nextLong());
	        customer.setAccount(account);
	        account.setCustomer(customer);

	        if (customerDao.saveCustomer(customer) != null) {
	            System.out.println("Customer saved successfully");
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void findAllCustomers() {
	        List<Customer> allCustomers = customerDao.getAllCustomers();
	        for (Customer customer : allCustomers) {
	            System.out.println(customer.getCustomerId() + " " + customer.getName() + " " + customer.getCity());
	        }
	    }

	    public void findCustomer() {
	        System.out.println("Enter customer ID:");
	        int id = sc.nextInt();
	        Customer customer = customerDao.findCustomer(id);
	        if (customer != null) {
	            System.out.println(customer.getCustomerId() + " " + customer.getName() + " " + customer.getCity());
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void updateCustomer() {
	        System.out.println("Enter customer ID:");
	        int id = sc.nextInt();
	        Customer customer = customerDao.findCustomer(id);
	        if (customer != null) {
	            System.out.println("1: Update name");
	            System.out.println("2: Update city");
	            System.out.println("3: Update contact");
	            int choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.println("Enter new name:");
	                    customer.setName(sc.next());
	                    break;
	                case 2:
	                    System.out.println("Enter new city:");
	                    customer.setCity(sc.next());
	                    break;
	                case 3:
	                    System.out.println("Enter new contact:");
	                    customer.setContact(sc.nextLong());
	                    break;
	                default:
	                    System.out.println("Invalid choice");
	                    return;
	            }
	            customerDao.updateCustomer(customer, id);
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }
	    
	    public void deleteCustomer() {
	        System.out.println("Enter customer ID:");
	        int id = sc.nextInt();
	        if (customerDao.deleteCustomer(id) != null) {
	            System.out.println("Customer deleted successfully");
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void saveManager() {
	        Manager manager = new Manager();
	        System.out.println("Enter manager name:");
	        manager.setManagerName(sc.next());
	        System.out.println("Enter manager city:");
	        manager.setCity(sc.next());
	        System.out.println("Enter manager contact number:");
	        manager.setContact(sc.nextLong());

	        // Assuming you have a method to list and select banks
	        System.out.println("Enter the bank ID to which the manager belongs:");
	        int bankId = sc.nextInt();
	        Bank bank = bankDao.findBank(bankId);
	        manager.setBank(bank);

	        if (managerDao.saveManager(manager) != null) {
	            System.out.println("Manager saved successfully");
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void findAllManagers() {
	        List<Manager> allManagers = managerDao.getAllManagers();
	        for (Manager manager : allManagers) {
	            System.out.println(manager.getManagerId() + " " + manager.getManagerName() + " " + manager.getCity());
	        }
	    }

	    public void findManager() {
	        System.out.println("Enter manager ID:");
	        int id = sc.nextInt();
	        Manager manager = managerDao.findManager(id);
	        if (manager != null) {
	            System.out.println(manager.getManagerId() + " " + manager.getManagerName() + " " + manager.getCity());
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void updateManager() {
	        System.out.println("Enter manager ID:");
	        int id = sc.nextInt();
	        Manager manager = managerDao.findManager(id);
	        if (manager != null) {
	            System.out.println("1: Update name");
	            System.out.println("2: Update city");
	            System.out.println("3: Update contact");
	            int choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.println("Enter new name:");
	                    manager.setManagerName(sc.next());
	                    break;
	                case 2:
	                    System.out.println("Enter new city:");
	                    manager.setCity(sc.next());
	                    break;
	                case 3:
	                    System.out.println("Enter new contact:");
	                    manager.setContact(sc.nextLong());
	                    break;
	                default:
	                    System.out.println("Invalid choice");
	                    return;
	            }
	            managerDao.updateManager(manager, id);
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void deleteManager() {
	        System.out.println("Enter manager ID:");
	        int id = sc.nextInt();
	        if (managerDao.deleteManager(id) != null) {
	            System.out.println("Manager deleted successfully");
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void saveAccount() {
	        Account account = new Account();
	        System.out.println("Enter account type:");
	        account.setAccType(sc.next());
	        System.out.println("Enter account balance:");
	        account.setAccBalance(sc.nextDouble());
	        System.out.println("Enter account number:");
	        account.setAccountNumber(sc.nextLong());

	        // Assuming you have a method to list and select customers
	        System.out.println("Enter the customer ID to which the account belongs:");
	        int customerId = sc.nextInt();
	        Customer customer = customerDao.findCustomer(customerId);
	        account.setCustomer(customer);

	        if (accountDao.saveAccount(account) != null) {
	            System.out.println("Account saved successfully");
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void findAllAccounts() {
	        List<Account> allAccounts = accountDao.getAllAccounts();
	        for (Account account : allAccounts) {
	            System.out.println(account.getAccountId() + " " + account.getAccType() + " " + account.getAccBalance());
	        }
	    }

	    public void findAccount() {
	        System.out.println("Enter account ID:");
	        int id = sc.nextInt();
	        Account account = accountDao.findAccount(id);
	        if (account != null) {
	            System.out.println(account.getAccountId() + " " + account.getAccType() + " " + account.getAccBalance());
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void updateAccount() {
	        System.out.println("Enter account ID:");
	        int id = sc.nextInt();
	        Account account = accountDao.findAccount(id);
	        if (account != null) {
	            System.out.println("1: Update account type");
	            System.out.println("2: Update account balance");
	            int choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.println("Enter new account type:");
	                    account.setAccType(sc.next());
	                    break;
	                case 2:
	                    System.out.println("Enter new account balance:");
	                    account.setAccBalance(sc.nextDouble());
	                    break;
	                default:
	                    System.out.println("Invalid choice");
	                    return;
	            }
	            accountDao.updateAccount(account, id);
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void deleteAccount() {
	        System.out.println("Enter account ID:");
	        int id = sc.nextInt();
	        if (accountDao.deleteAccount(id) != null) {
	            System.out.println("Account deleted successfully");
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }


	    public void saveTransaction() {
	        Transaction transaction = new Transaction();
	        System.out.println("Enter transaction type:");
	        transaction.setType(sc.next());
	        System.out.println("Enter transaction amount:");
	        transaction.setTransactionAmount(sc.nextDouble());
	        System.out.println("Enter transaction status:");
	        transaction.setStatus(sc.next());
	        System.out.println("Enter customer ID:");
	        transaction.setCustomerId(sc.nextInt());

	        if (transactionDao.saveTransaction(transaction) != null) {
	            System.out.println("Transaction saved successfully");
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void findAllTransactions() {
	        List<Transaction> allTransactions = transactionDao.getAllTransactions();
	        for (Transaction transaction : allTransactions) {
	            System.out.println(transaction);
	        }
	    }

	    public void findTransaction() {
	        System.out.println("Enter transaction ID:");
	        int id = sc.nextInt();
	        Transaction transaction = transactionDao.findTransaction(id);
	        if (transaction != null) {
	            System.out.println(transaction);
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void updateTransaction() {
	        System.out.println("Enter transaction ID:");
	        int id = sc.nextInt();
	        Transaction transaction = transactionDao.findTransaction(id);
	        if (transaction != null) {
	            System.out.println("1: Update transaction type");
	            System.out.println("2: Update transaction amount");
	            System.out.println("3: Update transaction status");
	            System.out.println("4: Update customer ID");
	            int choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.println("Enter new transaction type:");
	                    transaction.setType(sc.next());
	                    break;
	                case 2:
	                    System.out.println("Enter new transaction amount:");
	                    transaction.setTransactionAmount(sc.nextDouble());
	                    break;
	                case 3:
	                    System.out.println("Enter new transaction status:");
	                    transaction.setStatus(sc.next());
	                    break;
	                case 4:
	                    System.out.println("Enter new customer ID:");
	                    transaction.setCustomerId(sc.nextInt());
	                    break;
	                default:
	                    System.out.println("Invalid choice");
	                    return;
	            }
	            transactionDao.updateTransaction(transaction, id);
	        } else {
	            System.out.println("---------Failure--------");
	        }
	    }

	    public void deleteTransaction() {
	        System.out.println("Enter transaction ID:");
	        int id = sc.nextInt();
	        if (transactionDao.deleteTransaction(id) != null) {
	            System.out.println("Transaction deleted successfully");
	        } else {
	            System.out.println("---------Failure--------");
	        }

	    }

}
