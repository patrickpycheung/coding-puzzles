package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FloydTriangleService {

	public List<String> printFloydTriangle(List<Integer> inputList) {
		int rowNum = 1;
		int rowElemnetCount = 0;

		// Contains the display at the row
		String rowStr = "";
		// List of all the displays of each row
		List<String> rowStrList = new ArrayList<>();

		for (Integer input : inputList) {
			if (rowElemnetCount <= rowNum) {
				// Still have slots in this row

				rowStr = rowStr.concat(input + " ");

				// Advance one slot
				rowElemnetCount++;

				if (rowElemnetCount == rowNum) {
					// Is the last slot of this row

					// Store this row to list
					System.out.println(rowStr.trim());
					rowStrList.add(rowStr.trim());
					rowStr = "";

					// Advance 1 row
					rowNum++;
					rowElemnetCount = 0;
				}
			}
		}

		return rowStrList;
	}
}
