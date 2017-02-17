package com.NOBank.internetBanking.POJO;

import java.util.Scanner;

 public class Keyboard {
	Scanner kbd = new Scanner (System.in);
	public String nextLine(){
		 String yolo = kbd.nextLine();
		return yolo;
	}
	
}
