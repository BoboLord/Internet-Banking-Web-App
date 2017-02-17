package com.NOBank.internetBanking.POJO;

import org.springframework.beans.factory.annotation.Autowired;

import com.NOBank.internetBanking.DAO.UserAccountDAO;
import com.NOBank.internetBanking.Model.UserAccount;
import com.NOBank.internetBanking.POJO.Login;
import com.NOBank.internetBanking.Service.UserAccountService;

public class Login {
		
    @Autowired
    private UserAccountDAO userAccountDAO;
	
	 public void hello(){
		 Keyboard kbd = new Keyboard();
		    String choice = kbd.nextLine();
		 
			int choice1 = Integer.parseInt(choice);
			Login Login = new Login();
			if (choice1 == 1)
				Login.signIn();
			if (choice1 == 2)
				Login.register();
			else
				Main.enterChoice();
		 }

	  public void signIn() {
		  UserAccount useraccount = new UserAccount();

		  Keyboard kbd = new Keyboard();
			System.out.println("Please enter your email ID");
			useraccount.setEmail(kbd.nextLine());
			if (useraccount.getEmail().equals(null) || useraccount.getEmail().equals("")) {
				System.out.println("email cannot be left empty.");
				signIn();
			}

			System.out.println("Please enter your password");
			String temppass = kbd.nextLine();
			if (temppass.equals(null) || temppass.equals("")) {
				System.out.println("password cannot be left empty.");
				signIn();
			}
			
			useraccount = userAccountDAO.getAccountData(useraccount);
			
			if(useraccount.getPassword().equals(temppass))
			{
				System.out.println("Successfully logged in");
				Profile profile = new Profile();
				profile.profileDataExtracted(useraccount);
				
			}

			else{
				System.out.println("Username or password is incorrect");
				signIn();
			}
				

	}

	   public void register() {
		UserAccount useraccount = new UserAccount();
		System.out.println("You will be guided through a series of steps to register yourself");
		System.out.println(" ");
		UserAccountService useraccountservice = new UserAccountService();
		useraccountservice.saveUserAccount(useraccount);
	}


	   public void exitProgram() {
		System.out.println("Successfully logged out");
		Main.enterChoice();
	}
}
