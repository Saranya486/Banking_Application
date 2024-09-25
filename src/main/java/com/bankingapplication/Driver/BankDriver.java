package com.bankingapplication.Driver;

import java.util.Scanner;
import com.bankingapplication.controller.BankController;

public class BankDriver {

	public static void main(String[] args) {

        BankController controller = new BankController();
        boolean exit = false;

        Scanner sc = new Scanner(System.in);

        while (!exit) {

            System.out.println("<--------------- Welcome to Banking Application ------------>");
            System.out.println("1 -----> Create Bank");
            System.out.println("2 -----> Find All Banks");
            System.out.println("3 -----> Find Bank");
            System.out.println("4 -----> Update Bank");
            System.out.println("5 -----> Delete Bank");
            System.out.println("6 -----> Create Customer");
            System.out.println("7 -----> Find All Customers");
            System.out.println("8 -----> Find Customer");
            System.out.println("9 -----> Update Customer");
            System.out.println("10 -----> Delete Customer");
            System.out.println("11 -----> Create Manager");
            System.out.println("12 -----> Find All Managers");
            System.out.println("13 -----> Find Manager");
            System.out.println("14 -----> Update Manager");
            System.out.println("15 -----> Delete Manager");
            System.out.println("16 -----> Create Account");
            System.out.println("17 -----> Find All Accounts");
            System.out.println("18 -----> Find Account");
            System.out.println("19 -----> Update Account");
            System.out.println("20 -----> Delete Account");
            System.out.println("21 -----> Create Transaction");
            System.out.println("22 -----> Find All Transactions");
            System.out.println("23 -----> Find Transaction");
            System.out.println("24 -----> Update Transaction");
            System.out.println("25 -----> Delete Transaction");
            System.out.println("26 -----> Exit the Application");

            System.out.println("Enter your option:");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    controller.saveBank();
                    break;
                case 2:
                    controller.findAllBanks();
                    break;
                case 3:
                    controller.findBank();
                    break;
                case 4:
                    controller.updateBank();
                    break;
                case 5:
                    controller.deleteBank();
                    break;
                case 6:
                    controller.saveCustomer();
                    break;
                case 7:
                    controller.findAllCustomers();
                    break;
                case 8:
                    controller.findCustomer();
                    break;
                case 9:
                    controller.updateCustomer();
                    break;
                case 10:
                    controller.deleteCustomer();
                    break;
                case 11:
                    controller.saveManager();
                    break;
                case 12:
                    controller.findAllManagers();
                    break;
                case 13:
                    controller.findManager();
                    break;
                case 14:
                    controller.updateManager();
                    break;
                case 15:
                    controller.deleteManager();
                    break;
                case 16:
                    controller.saveAccount();
                    break;
                case 17:
                    controller.findAllAccounts();
                    break;
                case 18:
                    controller.findAccount();
                    break;
                case 19:
                    controller.updateAccount();
                    break;
                case 20:
                    controller.deleteAccount();
                    break;
                case 21:
                    controller.saveTransaction();
                    break;
                case 22:
                    controller.findAllTransactions();
                    break;
                case 23:
                    controller.findTransaction();
                    break;
                case 24:
                    controller.updateTransaction();
                    break;
                case 25:
                    controller.deleteTransaction();
                    break;
                case 26:
                    System.out.println("<---------------- Bye Bye ------------>");
                    exit = true;
                    break;
                default:
                    System.out.println("<---------------- Invalid Input ------------>");
                    break;
            }
        }

        sc.close();
    }

	}


