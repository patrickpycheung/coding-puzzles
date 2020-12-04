package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InsertionSortService {

	public List<Integer> doInsertionSort(List<Integer> inputList) {
		List<Integer> sortedList = new ArrayList<>();

		for (Integer input : inputList) {
			// Handle first member
			if (sortedList.size() == 0) {
				// Not yet have anything put in

				sortedList.add(input);
				continue;
			}

			if (input >= sortedList.get(sortedList.size() - 1)) {
				// Current input is less than every member in the sorted list

				sortedList.add(input);
			} else {
				for (int i = 0; i < sortedList.size(); i++) {

					if (input < sortedList.get(i)) {
						sortedList.add(i, input);
						break;
					}
				}
			}
		}

		return sortedList;
	}
}
