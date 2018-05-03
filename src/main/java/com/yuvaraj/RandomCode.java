package com.yuvaraj;

import java.util.Random;

public class RandomCode {
private static final String char_list="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
private static final int ran_string_len=10;

public String generateRandomCode() {
	StringBuffer randStr=new StringBuffer();
	for(int i=0; i<ran_string_len; i++){
        int number = getRandomNumber();
        char ch = char_list.charAt(number);
        randStr.append(ch);
    }
	return randStr.toString();
}
public int getRandomNumber() {
	 int randomInt = 0;
     Random randomGenerator = new Random();
     randomInt = randomGenerator.nextInt(char_list.length());
     if (randomInt - 1 == -1) {
         return randomInt;
     } else {
         return randomInt - 1;
     }
}
}
