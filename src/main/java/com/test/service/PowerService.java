package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class PowerService {

	public boolean isPowerOfTwo(int num) {

		/*
		 * Method 1
		 * 
		 * By the definition of logrithm
		 * 
		 * If there exist n such that n = 2^x => x = log2(n) => x = loge(n)/ loge(2)
		 * 
		 * Suppose if we can find an integer for x, then the proposition is true
		 * 
		 * But there may be overflow when we perform division on floating point numbers, hence this solution is not
		 * applicable
		 */

//		if (Math.log(num) % Math.log(2) == 0) {
//			return true;
//		}
//
//		return false;

		/*
		 * Method 2
		 * 
		 * By bit examination
		 * 
		 * For a number to be a power of 2, its bit representation should contain 1 and only 1 of "1"
		 * 
		 * 2^0 = 0000 0000 0000 0000 0000 0000 0000 0001
		 * 
		 * 2^1 = 0000 0000 0000 0000 0000 0000 0000 0010
		 * 
		 * 2^2 = 0000 0000 0000 0000 0000 0000 0000 0100
		 * 
		 * ...
		 * 
		 * ......
		 * 
		 * 2^30 = 0100 0000 0000 0000 0000 0000 0000 0000
		 */

		int oneCount = 0;

		// Perform bit shift beginning from the right hand side
		// i.e. see if it is 2^0, then check if it is 2^1, and so on
		// We try to shift the "supposed-to-be 1 bit" to the far right hand, and perform "AND" with "1" (i.e. 0000 0000
		// 0000 0000 0000 0000 0000 0001)
		for (int i = 0; i <= 30; i++) {
			if (((num >> i) & 1) == 1) {
				// Found a matching "1"

				oneCount++;

				if (oneCount > 1) {
					// Count of "1" is more than once

					return false;
				}
			}
		}

		if (oneCount == 1) {
			// Found exactly one of "1"

			return true;
		}

		return false;
	}
}
