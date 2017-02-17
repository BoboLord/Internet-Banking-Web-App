package com.NOBank.internetBanking.POJO;

import java.util.Random;

public class RandomNumberGenerator {
	public static int randInt() {

	    Random rand= new Random();
	    
	    int min = 1;
	    int max = 100;
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    randomNum = randomNum *1000;
	    return randomNum;
	}
}
