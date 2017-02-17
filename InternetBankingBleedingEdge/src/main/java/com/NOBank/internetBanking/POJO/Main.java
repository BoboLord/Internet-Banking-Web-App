package com.NOBank.internetBanking.POJO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.NOBank.internetBanking.DAO.UserAccountDAO;
import com.NOBank.internetBanking.Model.UserAccount;
import com.NOBank.internetBanking.POJO.Keyboard;


public class Main {
    @Autowired
    private UserAccountDAO userAccountDAO;

		 
	 public static void main(String args[]) {
		enterChoice();
	}
	
	  public static void enterChoice(){
			
			System.out.println("Welcome to NO Internet Banking");
			System.out.println("Please enter the number for the corresponding option you choose");
			System.out.println("Are you an already registered user?");
			System.out.println(" ");
			System.out.println("1.Yes, take me to login page");
			System.out.println("2.No, take me to registration page");
			System.out.println("3.Retreive all users");
			Main main = new Main();
			main.hello();
		}
	 
	  void hello(){
		Keyboard kbd = new Keyboard();
	    String choice = kbd.nextLine();
		int choice1 = Integer.parseInt(choice);
		Login login = new Login();
		if (choice1 == 1)
			login.signIn();
		if (choice1 == 2)
			login.register();
		if (choice1 == 3){
			List<UserAccount> users =userAccountDAO.retreiveAllAccounts();
	        for(UserAccount user : users) {
	            System.out.println(user.getFirstname());
	        }

		}
			
		else
			enterChoice();
	 }
}
