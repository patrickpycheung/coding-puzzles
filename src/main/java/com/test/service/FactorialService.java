package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class FactorialService {

	public static int fact(int input) {

		/*
		 * Method 1
		 * 
		 * By while loop
		 */

//		int result = 1;
//
//		int num = input;
//
//		while (num != 0) {
//			result = result * num;
//			num--;
//		}
//
//		return result;

		/*
		 * Method 2
		 * 
		 * By recursive function
		 */

		return factRecursive(input);
	}

	private static int factRecursive(int input) {

		if (input == 0) {
			return 1;
		}

		return input * factRecursive(input - 1);
	}

	public static void main(String args[]) {
		int result = fact(10);
		System.out.println(result);
	}
}
