package com.test.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MaximumMinimumArrayService {

	public static void largestAndSmallest(int[] numbers) {
		List<Integer> numList = new ArrayList<>();

		for (int num : numbers) {
			numList.add(num);
		}

		Collections.sort(numList);

		System.out.println("Largest number: " + numList.get(numList.size() - 1));
		System.out.println("Smallest number: " + numList.get(0));
	}

	public static void main(String args[]) {
		int[] numbers = new int[3];
		numbers[0] = 1;
		numbers[1] = 2;
		numbers[2] = 3;

		largestAndSmallest(numbers);
	}
}
