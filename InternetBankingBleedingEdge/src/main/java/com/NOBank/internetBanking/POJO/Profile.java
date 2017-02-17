package com.NOBank.internetBanking.POJO;

import org.springframework.beans.factory.annotation.Autowired;

import com.NOBank.internetBanking.DAO.UserAccountDAO;
import com.NOBank.internetBanking.Model.UserAccount;
import com.NOBank.internetBanking.Service.TransactionService;

public class Profile {

    @Autowired
    private UserAccountDAO userAccountDAO;

	public void profileDataExtracted(UserAccount useraccount) {
		TransactionService transactionservice = new TransactionService();
		    
			System.out.println("Email ID:" + useraccount.getEmail());
			System.out.println("Primary account number: " + useraccount.getAccount1());
			useraccount.setAccount(useraccount.getAccount1());
			System.out.println("The account balance is: "+transactionservice.currentBalance(useraccount.getAccount()));
			System.out.println("First name: " + useraccount.getFirstname());
			System.out.println("Last name: " + useraccount.getLastname());
			System.out.println("Phone number: " + useraccount.getPhone());
			System.out.println("D.O.B: " + useraccount.getDOB());
			ListOperations ListOperations = new ListOperations();
			ListOperations.jelly4(useraccount);
		}


	  public void editProfileInformation(UserAccount useraccount) {

		Keyboard kbd = new Keyboard();
		ListOperations ListOperations = new ListOperations();
		String a = "emailid";
		String b = "firstname";
		String c = "lastname";
		String d = "phone";
		String e = "DOB";
		String f = "password";
		String g = "go back";
		System.out.println("What information would you like to edit? \n1." + a + "\n2." + b + "\n3." + c + "\n4." + d
				+ "\n5." + e + "\n6." + f + "\n7." + g);

		String userchoice1 = kbd.nextLine();

		int userchoice = Integer.parseInt(userchoice1);
		switch (userchoice) {
		case 1:
			System.out.println("Enter new " + a);
			useraccount.setEmail(kbd.nextLine());
			break;

		case 2:
			System.out.println("Enter new " + b);
			useraccount.setFirstname(kbd.nextLine());
			break;

		case 3:
			System.out.println("Enter new " + c);
			useraccount.setLastname(kbd.nextLine());

			break;
		case 4:
			System.out.println("Enter new " + d);
			useraccount.setPhone(kbd.nextLine());

			break;
		case 5:
			System.out.println("Enter new " + e);
			useraccount.setDOB(kbd.nextLine());

			break;
		case 6:
			System.out.println("Enter new " + f);
			String password1 = kbd.nextLine();
			System.out.println("Reenter new " + f);
			String password2 = kbd.nextLine();
			if (password1 == password2) {
				useraccount.setPassword(password2);
			} else {
				System.out.println("Passwords do not match");
				editProfileInformation(useraccount);
			}
			break;

		case 7:
			ListOperations.jelly(useraccount);
			break;

		}
		userAccountDAO.update(useraccount);

		profileDataExtracted(useraccount);

	}

	 public void checkuser(UserAccount useraccount) {
		Keyboard kbd = new Keyboard();
		System.out.println("Do you want to save the information ?" + "\n 1. Yes" + "\n 2.Revert the changes");
		String check1 = kbd.nextLine();
		int check = Integer.parseInt(check1);
		if (check != 1) {
			System.out.println("Information not saved");
			editProfileInformation(useraccount);

		}

	}
}
