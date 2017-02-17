package com.NOBank.internetBanking.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.NOBank.internetBanking.DAO.UserAccountDAO;
import com.NOBank.internetBanking.DAO.TransactionDAO;
import com.NOBank.internetBanking.Model.Transaction;
import com.NOBank.internetBanking.Model.UserAccount;
import com.NOBank.internetBanking.POJO.Keyboard;
import com.NOBank.internetBanking.POJO.ListOperations;
import com.NOBank.internetBanking.POJO.Main;
import com.NOBank.internetBanking.POJO.Profile;
import com.NOBank.internetBanking.POJO.RandomNumberGenerator;

public class UserAccountService {
	

    @Autowired
    private UserAccountDAO userAccountDAO;
    @Autowired
    private TransactionDAO transactionDAO;
	@Transactional
    public void save(UserAccount useraccount) {
		
		userAccountDAO.save(useraccount);
    }

    
	private static List<UserAccount> users;
	
	
	@Transactional
	public List<UserAccount> retreiveAllUsers() {
		
		List<UserAccount> users =userAccountDAO.retreiveAllAccounts();
        for(UserAccount user : users) {
            System.out.println(user.getFirstname());
        }

		return users;
	}
	
	public UserAccount findById(int id) {
		for(UserAccount user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public UserAccount findByFirstname(String name) {
		for(UserAccount user : users){
			if(user.getFirstname().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}

	public void saveUserAccount(UserAccount useraccount){
		
		enterEmail(useraccount);
		enterPassword(useraccount);
		enterfirstname(useraccount);
		enterlastname(useraccount);
		enteraccount(useraccount);
		enterphone(useraccount);
		enterDOB(useraccount);
		complete(useraccount);

	}
	
	   public void enterEmail(UserAccount useraccount) {
		   Keyboard kbd = new Keyboard();
		
		System.out.println("Please enter your email address. This will be used to login");
		useraccount.setEmail(kbd.nextLine());
		
		if (useraccount.getEmail().equals(null) || useraccount.getEmail().equals("")) {
			System.out.println("field cannot be left empty.");
			enterEmail(useraccount);
		}
		if (useraccount.getEmail()!=null){
			System.out.println("email ID has already been registered");
			enterEmail(useraccount);
		}
	}

	   public void enterPassword(UserAccount useraccount) {
		String password1 = firstPassword();
		String password2 = secondPassword();

		if (password1.equals(null) || password1.equals("")) {
			System.out.println("Password cannot be empty");
			enterPassword(useraccount);
		}
		if (password2.equals(password1)) {
			System.out.println("Passwords match");
			useraccount.setPassword(password1);
		}

		else {
			System.out.println("Passwords do not match!");
			enterPassword(useraccount);
		}
	}

	   String firstPassword() {
		   Keyboard kbd = new Keyboard();
		System.out.println("Please enter an alphanumeric password");
		String password1 = kbd.nextLine();
		return password1;
	}

	   String secondPassword() {
		   Keyboard kbd = new Keyboard();
		System.out.println("Please reenter your password");
		String password2 = kbd.nextLine();
		return password2;
	}

	   public void enterfirstname(UserAccount useraccount) {
		   Keyboard kbd = new Keyboard();
		System.out.println("Please enter your first name");
		useraccount.setFirstname(kbd.nextLine());
		if (useraccount.getFirstname().equals(null) || useraccount.getFirstname().equals("")) {
			System.out.println("field cannot be left empty.");
			enterfirstname(useraccount);
		} 

	}

	   public void enterlastname(UserAccount useraccount) {
		   Keyboard kbd = new Keyboard();
		System.out.println("Please enter your last name");
		useraccount.setLastname(kbd.nextLine());
		if (useraccount.getLastname().equals(null) || useraccount.getLastname().equals("")) {
			System.out.println("field cannot be left empty.");
			enterlastname(useraccount);
		} 

	}

	   public void enteraccount(UserAccount useraccount) {
		   Keyboard kbd = new Keyboard();
		System.out.println("Please enter your account number to be associated as your primary account number");
		useraccount.setAccount1(kbd.nextLine());
		if (useraccount.getAccount1().equals(null) || useraccount.getAccount().equals("")) {
			System.out.println("field cannot be left empty.");
			enteraccount(useraccount);
		} 
	}

	   public void enterphone(UserAccount useraccount) {
		   Keyboard kbd = new Keyboard();
		System.out.println("Please enter your mobile number(This will be used to notify via SMS) ");
		useraccount.setPhone(kbd.nextLine());
		if (useraccount.getPhone().equals(null) || useraccount.getPhone().equals("")) {
			System.out.println("field cannot be left empty.");
			enterphone(useraccount);
		}
	}

	   public void enterDOB(UserAccount useraccount) {
		   Keyboard kbd = new Keyboard();
		System.out.println("Please enter your D.O.B with ddmmyy format(Used for verification in password recovery)");
		useraccount.setDOB(kbd.nextLine());
		if (useraccount.getDOB().equals(null) || useraccount.getDOB().equals("")) {
			System.out.println("field cannot be left empty.");
			enterDOB(useraccount);
		} 
		
	}
		@Transactional
	   public void complete(UserAccount useraccount) {
		   Keyboard kbd = new Keyboard();
		Transaction transaction = new Transaction();
		
		transaction.sender = "Base Amount";
		transaction.receiver = useraccount.getAccount1();
		transaction.amount = RandomNumberGenerator.randInt();

		System.out.println("hello1");
		userAccountDAO.save(useraccount);
		System.out.println("hello1");
		transactionDAO.save(transaction);
		System.out.println("Registration complete." + "\n 1. Click here if you'd like to continue to use our services"
				+ "\n 2. Click here to exit");

		String choice = kbd.nextLine();
		int choice1 = Integer.parseInt(choice);

		while (choice1 < 1 || choice1 > 2) {
			System.out.println("Invalid choice. Enter a valid number");
			String choice2 = kbd.nextLine();
			choice1 = Integer.parseInt(choice2);

		}
		
		switch (choice1) {
		case 1:
			
			ListOperations ListOperations = new ListOperations();
			System.out.println("Successfully logged in.");
			Profile profile = new Profile();
			profile.profileDataExtracted(useraccount);
			ListOperations.jelly3(useraccount);
			break;
		case 2:
			   
			System.out.println("Successfully logged out");
			Main.enterChoice();
			break;
		}
	}

	public void viewAccounts(UserAccount useraccount) {
		Keyboard kbd = new Keyboard();
		ListOperations listoperations = new ListOperations();
		
		   
		if (!useraccount.getAccount1().equals("na")) {
			System.out.println("Currently registered accounts are:");
			if (!useraccount.getAccount1().equals("na"))
			System.out.println("1. Account 1: " + useraccount.getAccount1());
			if (!useraccount.getAccount2().equals("na"))
				System.out.println("2. Account 2: " + useraccount.getAccount2());
			if (!useraccount.getAccount3().equals("na"))
				System.out.println("3. Account 3: " + useraccount.getAccount3());
			if (!useraccount.getAccount4().equals("na"))
				System.out.println("4. Account 4: " + useraccount.getAccount4());
			if (!useraccount.getAccount5().equals("na"))
				System.out.println("5. Account 5: " + useraccount.getAccount5());
		} else {
			System.out.println("\nThere are currently no beneficiaries. Would you like"
					+ " to \n1.Add a beneficiary \n2.Go back");
			String choice = kbd.nextLine();
			if (choice.equals("1"))
				addAccount(useraccount);
			else{
				listoperations.jelly(useraccount);
			}

		}

	}
	
	public String selectAccount(UserAccount useraccount) {
		Keyboard kbd = new Keyboard();
		String choice = "-1";

	
		System.out.println("Please select an account: ");
		choice = kbd.nextLine();

		if (choice.equals("1")) {
			useraccount.setAccount(useraccount.getAccount1());
		}
		if (choice.equals("2")) {
			useraccount.setAccount(useraccount.getAccount2());
		}
		if (choice.equals("3")) {
			useraccount.setAccount(useraccount.getAccount3());
		}
		if (choice.equals("4")) {
			useraccount.setAccount(useraccount.getAccount4());
		}
		if (choice.equals("5")) {
			useraccount.setAccount(useraccount.getAccount5());
		}
		if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")
				&& !choice.equals("5")) {
			System.out.println("Enter a valid number");
			selectAccount(useraccount);
				}
		return useraccount.getAccount();
	}
	
	String selectBeneficiary(UserAccount useraccount) {
		Keyboard kbd = new Keyboard();
		String choice = "-1";

		System.out.println("Please select a beneficiary: ");
		choice = kbd.nextLine();

		if (choice.equals("1")) {
			useraccount.setBeneficiary(useraccount.getBeneficiary1());
		}
		if (choice.equals("2")) {
			useraccount.setBeneficiary(useraccount.getBeneficiary2());
		}
		if (choice.equals("3")) {
			useraccount.setBeneficiary(useraccount.getBeneficiary3());
		}
		if (choice.equals("4")) {
			useraccount.setBeneficiary(useraccount.getBeneficiary4());
		}
		if (choice.equals("5")) {
			useraccount.setBeneficiary(useraccount.getBeneficiary5());
		}
		if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")
				&& !choice.equals("5")) {
			System.out.println("Enter a valid number");
			selectBeneficiary(useraccount);
				}
		return useraccount.getBeneficiary();
	}

	@Transactional
	public void addAccount(UserAccount useraccount) {
		Keyboard kbd = new Keyboard();
		ListOperations listoperations = new ListOperations();

		if (!useraccount.getAccount1().equals("na")) {
			if (useraccount.getAccount1().equals("na")){
			System.out.println("Add new account 1: ");
			useraccount.setAccount1(kbd.nextLine());
			userAccountDAO.update(useraccount);
			System.out.println("Successfully added new account 1: " + useraccount.getAccount1());
			listoperations.jelly(useraccount);
			}
			if (useraccount.getAccount2().equals("na")){
				System.out.println("Add new account 2: ");
				useraccount.setAccount2(kbd.nextLine());
				userAccountDAO.update(useraccount);
				System.out.println("Successfully added new account 2: " + useraccount.getAccount2());
				listoperations.jelly(useraccount);
			}
			if (useraccount.getAccount3().equals("na")){
				System.out.println("Add new account 3: ");
				useraccount.setAccount3(kbd.nextLine());
				userAccountDAO.update(useraccount);
				System.out.println("Successfully added new account 3: " + useraccount.getAccount3());
				listoperations.jelly(useraccount);
			}
			if (useraccount.getAccount4().equals("na")){
				System.out.println("Add new account 4: ");
				useraccount.setAccount4(kbd.nextLine());
				userAccountDAO.update(useraccount);
				System.out.println("Successfully added new account 4: " + useraccount.getAccount4());
				listoperations.jelly(useraccount);
			}
			if (useraccount.getAccount5().equals("na")){
				System.out.println("Add new account 5: ");
				useraccount.setAccount5(kbd.nextLine());
				userAccountDAO.update(useraccount);
				System.out.println("Successfully added new account 1: " + useraccount.getAccount1());
				listoperations.jelly(useraccount);
			}
		} else {
			System.out.println("\nYou already have five beneficiaries. Would you like to change a account?");
			String choice = kbd.nextLine();
			if (choice.equals("1"))
				editAccount(useraccount);
			else{
				listoperations.jelly(useraccount);
			}

		}

	}
	
	public void editAccount(UserAccount useraccount) {
		Keyboard kbd = new Keyboard();
		ListOperations listoperations = new ListOperations();

		viewBeneficiaries(useraccount);
		selectAccount(useraccount);
		System.out.println("Enter the number coresponding to the account to be changed: ");
		String choice = kbd.nextLine();
		if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")
				&& !choice.equals("5")) {
			System.out.println("Invalid choice \n");
		}
		String newaccount = "-1";
		System.out.println("Enter the account number you would like to add: ");

		newaccount = kbd.nextLine();

		
			if (choice.equals("1")){
			useraccount.setAccount1(newaccount);
			System.out.println("Successfully added new account 1: " + useraccount.getAccount1());
			listoperations.jelly(useraccount);
			}
			if (choice.equals("2")){
				useraccount.setAccount2(newaccount);
				System.out.println("Successfully added new account 2: " + useraccount.getAccount2());
				listoperations.jelly(useraccount);
			}
			if (choice.equals("3")){
				useraccount.setAccount3(newaccount);
				System.out.println("Successfully added new account 3: " + useraccount.getAccount3());
				listoperations.jelly(useraccount);
			}
			if (choice.equals("4")){
				useraccount.setAccount4(newaccount);
				System.out.println("Successfully added new account 4: " + useraccount.getAccount4());
				listoperations.jelly(useraccount);
			}
			if (choice.equals("5")){
				useraccount.setAccount5(newaccount);
				System.out.println("Successfully added new account 1: " + useraccount.getAccount1());
				listoperations.jelly(useraccount);
			}
			userAccountDAO.update(useraccount);


	  }
	
	@Transactional
	public void viewBeneficiaries(UserAccount useraccount) {
		Keyboard kbd = new Keyboard();
		ListOperations listoperations = new ListOperations();

		if (!useraccount.getBeneficiary1().equals("na")) {
			System.out.println("1. Beneficiary 1: " + useraccount.getBeneficiary1());
			if (!useraccount.getBeneficiary2().equals("na"))
				System.out.println("2. Beneficiary 2: " + useraccount.getBeneficiary2());
			if (!useraccount.getBeneficiary3().equals("na"))
				System.out.println("3. Beneficiary 3: " + useraccount.getBeneficiary3());
			if (!useraccount.getBeneficiary4().equals("na"))
				System.out.println("4. Beneficiary 4: " + useraccount.getBeneficiary4());
			if (!useraccount.getBeneficiary5().equals("na"))
				System.out.println("5. Beneficiary 5: " + useraccount.getBeneficiary5());
		} else {
			System.out.println("\nThere are currently no beneficiaries. Would you like"
					+ " to \n1.Add a beneficiary \n2.Go back");
			String choice = kbd.nextLine();
			if (choice.equals("1"))
				addBeneficiary(useraccount);
			else{
				listoperations.jelly(useraccount);
			}

		}

	}
	
	public void addBeneficiary(UserAccount useraccount) {
		Keyboard kbd = new Keyboard();
		ListOperations listoperations = new ListOperations();
		
			if (useraccount.getBeneficiary1().equals("na")){
			System.out.println("Add new beneficiary 1: ");
			useraccount.setBeneficiary1(kbd.nextLine());
			userAccountDAO.update(useraccount);
			System.out.println("Successfully added new beneficiary 1: " + useraccount.getBeneficiary1());
			listoperations.jelly(useraccount);
			}
			if (useraccount.getBeneficiary2().equals("na")){
				System.out.println("Add new beneficiary 2: ");
				useraccount.setBeneficiary2(kbd.nextLine());
				userAccountDAO.update(useraccount);
				System.out.println("Successfully added new beneficiary 2: " + useraccount.getBeneficiary2());
				listoperations.jelly(useraccount);
			}
			if (useraccount.getBeneficiary3().equals("na")){
				System.out.println("Add new beneficiary 3: ");
				useraccount.setBeneficiary3(kbd.nextLine());
				userAccountDAO.update(useraccount);
				System.out.println("Successfully added new beneficiary 3: " + useraccount.getBeneficiary3());
				listoperations.jelly(useraccount);
			}
			if (useraccount.getBeneficiary4().equals("na")){
				System.out.println("Add new beneficiary 4: ");
				useraccount.setBeneficiary4(kbd.nextLine());
				userAccountDAO.update(useraccount);
				System.out.println("Successfully added new beneficiary 4: " + useraccount.getBeneficiary4());
				listoperations.jelly(useraccount);
			}
			if (useraccount.getBeneficiary5().equals("na")){
				System.out.println("Add new beneficiary 5: ");
				useraccount.setBeneficiary5(kbd.nextLine());
				userAccountDAO.update(useraccount);
				System.out.println("Successfully added new beneficiary 1: " + useraccount.getBeneficiary1());
				listoperations.jelly(useraccount);
			}
		
			System.out.println("\nYou already have five beneficiaries. Would you like to change a beneficiary?");
			String choice = kbd.nextLine();
			if (choice.equals("1"))
				editBeneficiary(useraccount);
			else{
				listoperations.jelly(useraccount);
			}

		

	}
	
	@Transactional
	public void editBeneficiary(UserAccount useraccount) {
		Keyboard kbd = new Keyboard();
		ListOperations listoperations = new ListOperations();

		viewBeneficiaries(useraccount);
		System.out.println("Enter the number coresponding to the beneficiary to be changed: ");
		String choice = kbd.nextLine();
		if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")
				&& !choice.equals("5")) {
			System.out.println("Invalid choice \n");
		}
		String newaccount = "-1";
		System.out.println("Enter the account number you would like to add: ");

		newaccount = kbd.nextLine();

		
			if (choice.equals("1")){
			useraccount.setBeneficiary1(newaccount);
			System.out.println("Successfully added new beneficiary 1: " + useraccount.getBeneficiary1());
			listoperations.jelly(useraccount);
			}
			if (choice.equals("2")){
				useraccount.setBeneficiary2(newaccount);
				System.out.println("Successfully added new beneficiary 2: " + useraccount.getBeneficiary2());
				listoperations.jelly(useraccount);
			}
			if (choice.equals("3")){
				useraccount.setBeneficiary3(newaccount);
				System.out.println("Successfully added new beneficiary 3: " + useraccount.getBeneficiary3());
				listoperations.jelly(useraccount);
			}
			if (choice.equals("4")){
				useraccount.setBeneficiary4(newaccount);
				System.out.println("Successfully added new beneficiary 4: " + useraccount.getBeneficiary4());
				listoperations.jelly(useraccount);
			}
			if (choice.equals("5")){
				useraccount.setBeneficiary5(newaccount);
				System.out.println("Successfully added new beneficiary 1: " + useraccount.getBeneficiary1());
				listoperations.jelly(useraccount);
			}
			userAccountDAO.update(useraccount);
	  }




	@Transactional
	public void updateUser(UserAccount currentUserAccount) {
		userAccountDAO.update(currentUserAccount);
	}
	@Transactional
	public void deleteUserById(int id) {
		userAccountDAO.delete(id);
	}

}


