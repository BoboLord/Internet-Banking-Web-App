package com.NOBank.internetBanking.POJO;

import java.util.Scanner;

import com.NOBank.internetBanking.Model.UserAccount;
import com.NOBank.internetBanking.Service.TransactionService;
import com.NOBank.internetBanking.Service.UserAccountService;

public class ListOperations {

	
	   public void jelly(UserAccount useraccount) {
		Login Login = new Login();
		Profile Profile = new Profile();
		TransactionService transactionservice = new TransactionService();
		UserAccountService useraccountservice = new UserAccountService();

		int n = 1;
		System.out.println("\nThese are the list of operations allowed \n" + n++ + ". View current balance \n" + n++
				+ ". View detailed bank statement \n" + n++ + ". View existing accounts \n" + n++
				+ ". Add an account \n" + n++ + ". Edit an existing account \n" + n++ + ". View Existing Beneficiay \n"
				+ n++ + ". Add a beneficiary \n" + n++ + ". Edit existing beneficiary \n" + n++
				+ ". Send Money to Beneficiary \n" + n++ + ". Easy Money Transfer \n" + n++ + ". UPI \n" + n++
				+ ". Display profile information \n" + n++ + ". Edit profile information \n" + n++ + ". Logout \n");

		Scanner kbd = new Scanner(System.in);
		String choice = kbd.nextLine();
		if (choice.equals("1")) {
			useraccount.setAccount(useraccount.getAccount1());
			System.out.println("The account balance is: "+transactionservice.currentBalance(useraccount.getAccount()));
			jelly3(useraccount);

		}
		if (choice.equals("2")) {
			useraccountservice.viewAccounts(useraccount);
			String account = useraccountservice.selectAccount(useraccount);
			transactionservice.detailedStatement(account);
			jelly3(useraccount);
		}
		if (choice.equals("3")) {
			useraccountservice.viewAccounts(useraccount);
			jelly3(useraccount);
		}
		if (choice.equals("4")) {
			useraccountservice.addAccount(useraccount);
		}
		if (choice.equals("5")) {
			useraccountservice.editAccount(useraccount);
		}
		if (choice.equals("6")) {
			useraccountservice.viewBeneficiaries(useraccount);
			jelly3(useraccount);
		}
		if (choice.equals("7")) {
			useraccountservice.addBeneficiary(useraccount);
			jelly3(useraccount);

		}
		if (choice.equals("8")) {
			useraccountservice.editBeneficiary(useraccount);
			jelly3(useraccount);
		}
		if (choice.equals("9")) {

			transactionservice.sendBeneficiary(useraccount);
			jelly3(useraccount);
		}
		if (choice.equals("10")) {

			transactionservice.sendAmount(useraccount);
		}
		if (choice.equals("11")) {
			System.out.println("Function still hasn't been implemented \n");
			jelly3(useraccount);
		}
		if (choice.equals("12")) {
			Profile.profileDataExtracted(useraccount);
		}
		if (choice.equals("13")) {
			Profile.editProfileInformation(useraccount);
		}
		if (choice.equals("14")) {
			Login.exitProgram();
		}

		else {
			System.out.println("Please enter a valid number");
			jelly3(useraccount);
		}
		kbd.close();
	}

	  void jelly2(UserAccount useraccount) {
		Profile Profile = new Profile();
		Login Login = new Login();
		
		System.out.println("Would you like to:" + "\n 1. edit your profile information"
				+ "\n 2. continue with other operations" + "\n 3. logout");
		Scanner kbd = new Scanner(System.in);
		String choice = kbd.nextLine();
		if (choice.equals("1")) {
			Profile.editProfileInformation(useraccount);

		}
		if (choice.equals("2")) {
			jelly(useraccount);

		}
		if (choice.equals("3")) {
			Login.exitProgram();
		}

		kbd.close();
	}

	  public void jelly3(UserAccount useraccount) {
		Login Login = new Login();
		System.out.println("Would you like to:" + "\n 1. continue with other operations" + "\n 2. logout");
		Scanner kbd = new Scanner(System.in);
		String choice1 = kbd.nextLine();
		int choice = Integer.parseInt(choice1);
		if (choice == 1) {
			jelly(useraccount);

		}
		if (choice == 2) {
			Login.exitProgram();
		}
		kbd.close();
	}

	  void jelly4(UserAccount useraccount) {
		Keyboard kbd = new Keyboard();
		System.out.println("Would you like to:" + "\n 1. Continue using our online services" + "\n 2. logout");
		String choice1 = kbd.nextLine();
		int choice = Integer.parseInt(choice1);
		if (choice == 1) {
			jelly(useraccount);

		}
		if (choice == 2) {
			Login login = new Login();
			login.exitProgram();
		} else {
			System.out.println("enter a valid number");
			
			jelly4(useraccount);
		}

	}

}
