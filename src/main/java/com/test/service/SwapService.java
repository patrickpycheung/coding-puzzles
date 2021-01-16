package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class SwapService {

	public static void swap(int x, int y) {
		System.out.println("x: " + x);
		System.out.println("y: " + y);

		/*
		 * Method 1
		 * 
		 * By XOR
		 */

		y = x ^ y;
		x = x ^ y;
		y = x ^ y;

		/*
		 * Method 2
		 * 
		 * By addition and subtraction
		 */

//		y = x + y;
//		x = y - x;
//		y = y - x;
//
//		System.out.println("x: " + x);
//		System.out.println("y: " + y);

	}

	public static void main(String args[]) {
		swap(1, 2);
	}
}
