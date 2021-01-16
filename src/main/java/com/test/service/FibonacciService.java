package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

	public static List<Integer> printFibonacciSeries(int num) {

		/**
		 * Method 1
		 * 
		 * By for loop
		 */

		List<Integer> sequenceList = new ArrayList<>();

		// Special handle the first 2 elements in the series

		if (num >= 1) {
			System.out.print(1 + " ");
			sequenceList.add(1);
		}

		if (num >= 2) {
			System.out.print(1 + " ");
			sequenceList.add(1);
		}

		// Handle the rest

		if (num >= 3) {
			int fn1 = 1;
			int fn2 = 1;

			for (int i = 3; i <= num; i++) {
				int current = fn1 + fn2;
				System.out.print(current + " ");
				sequenceList.add(current);

				// Shift elements to the right
				fn2 = fn1;
				fn1 = current;
			}

			System.out.println();
		}

		return sequenceList;

		/*
		 * Method 2
		 * 
		 * By recursive function
		 */

//		// Final result list
//		List<Integer> sequenceList = new ArrayList<>();
//
//		for (int i = 1; i <= num; i++) {
//			int currentElement = getFibonacciRecursive(i);
//			System.out.print(currentElement + " ");
//			sequenceList.add(currentElement);
//		}
//
//		return sequenceList;
//	}
//
//	private static int getFibonacciRecursive(int n) {
//		if (n == 1) {
//			return 1;
//		}
//
//		if (n == 2) {
//			return 1;
//		}
//
//		return getFibonacciRecursive(n - 1) + getFibonacciRecursive(n - 2);
	}

	public static void main(String args[]) {
		printFibonacciSeries(10);
	}
}