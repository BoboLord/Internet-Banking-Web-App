package com.NOBank.internetBanking.Service;

import java.util.Date;
import java.util.ListIterator;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.NOBank.internetBanking.DAO.TransactionDAO;
import com.NOBank.internetBanking.Model.Transaction;
import com.NOBank.internetBanking.Model.UserAccount;
import com.NOBank.internetBanking.POJO.Keyboard;
import com.NOBank.internetBanking.POJO.ListOperations;

public class TransactionService{
	
    @Autowired
    private TransactionDAO transactionDAO;


	public String timeStamp() {
		String timestamp = new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(new Date());
		return timestamp;
	}
	@Transactional
	public void sendAmount(UserAccount useraccount) {
		Transaction transaction = new Transaction();
		UserAccountService useraccountservice = new UserAccountService();
		Keyboard kbd = new Keyboard();
		ListOperations listoperations = new ListOperations();
		useraccountservice.viewAccounts(useraccount);
		transaction.sender = useraccountservice.selectAccount(useraccount);
		System.out.println("Enter the receiver's account number: ");
		transaction.receiver = kbd.nextLine();

		System.out.println("Enter the amount you wish to transfer: ");
		String temp = kbd.nextLine();
		transaction.amount = Integer.parseInt(temp);

		transactionDAO.save(transaction);
		System.out
				.println("Rs." + transaction.amount + " has been successfully transferred to " + transaction.receiver);

		listoperations.jelly3(useraccount);
	}
	@Transactional
	public void sendBeneficiary(UserAccount useraccount) {
		UserAccountService useraccountservice = new UserAccountService();
		Transaction transaction = new Transaction();
		
		Keyboard kbd = new Keyboard();
		ListOperations listoperations = new ListOperations();
		useraccountservice.viewAccounts(useraccount);
		transaction.sender = useraccountservice.selectAccount(useraccount);
		useraccountservice.viewBeneficiaries(useraccount);
		transaction.receiver = useraccountservice.selectBeneficiary(useraccount);

		System.out.println("Enter the amount you wish to transfer: ");
		String temp = kbd.nextLine();
		transaction.amount = Integer.parseInt(temp);

		transactionDAO.save(transaction);
		System.out
				.println("Rs." + transaction.amount + " has been successfully transferred to " + transaction.receiver);

		listoperations.jelly3(useraccount);
	}
	@Transactional
	public void detailedStatement(String account) {
		Transaction transaction = new Transaction();
		ListIterator<Transaction> itr = transactionDAO.selectList(account).listIterator();
		int currentamount = 0;
		while (itr.hasNext()) {

			Transaction next = (Transaction) itr.next();

			transaction.sender = next.getSender();
			transaction.receiver = next.getReceiver();
			transaction.amount = next.getAmount();
			transaction.timestamp = next.getTimestamp();

			if (transaction.receiver.equals(account) && transaction.sender.equals("Base Amount")) {
				currentamount = currentamount + transaction.amount;
				System.out.println("Rs." + transaction.amount + " credited as " + transaction.sender + " on "
						+ transaction.timestamp);

			}
			if (transaction.receiver.equals(account) && !transaction.sender.equals("Base Amount")) {
				currentamount = currentamount + transaction.amount;
				System.out.println("Rs." + transaction.amount + " received from " + transaction.sender + " on "
						+ transaction.timestamp);
				System.out.println("Balance after transaction is " + currentamount);
			}
			if (transaction.sender.equals(account)) {
				currentamount = currentamount - transaction.amount;
				System.out.println("Rs." + transaction.amount + " sent to " + transaction.receiver + " on "
						+ transaction.timestamp);
				System.out.println("Balance after transaction is " + currentamount);

			}

		}

	}
	@Transactional
	public int currentBalance(String account) {
		Transaction transaction = new Transaction();
		ListIterator<Transaction> itr = transactionDAO.selectList(account).listIterator();
		int currentamount = 0;
		while (itr.hasNext()) {

			Transaction next = (Transaction) itr.next();

			transaction.sender = next.getSender();
			transaction.receiver = next.getReceiver();
			transaction.amount = next.getAmount();
			transaction.timestamp = next.getTimestamp();

			if (transaction.receiver.equals(account) && transaction.sender.equals("Base Amount")) {
				currentamount = currentamount + transaction.amount;
			}
			if (transaction.receiver.equals(account) && !transaction.sender.equals("Base Amount")) {
				currentamount = currentamount + transaction.amount;
			}
			if (transaction.sender.equals(account)) {
				currentamount = currentamount - transaction.amount;
			}
		}
		return currentamount;

	}
}
