package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class ReplaceSpaceService {

	public char[] replaceSpaces(char[] str, int length) {
		/*
		 * Assumption:
		 * 
		 * str has enough extra space to store the additional characters.
		 */

		// Find the new length required

		int spaceCount = 0;

		for (char ch : str) {
			if (ch == ' ') {
				// Is empty character

				spaceCount++;
			}
		}

		int newLength = length + spaceCount * 2;

		// Rearrange characters in str

		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				// Is empty char

				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';

				newLength -= 3;
			} else {
				// Not empty char

				str[newLength - 1] = str[i];

				newLength--;
			}
		}

		return str;
	}
}
