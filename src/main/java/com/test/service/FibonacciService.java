package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

	public List<Integer> printFibonacciSeries(int num) {

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
	}
}
