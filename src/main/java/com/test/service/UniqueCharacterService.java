package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class UniqueCharacterService {

	public boolean isUniqueChars(String str) {

		// Stores used characters
		boolean[] usageRecord = new boolean[256];

		for (int i = 0; i < str.length(); i++) {
			char currentCh = str.charAt(i);
			// Convert to ascii value
			int asciiValue = currentCh;

			if (usageRecord[asciiValue] == true) {
				// Character already been used

				return false;
			} else {
				// Character not yet been used

				usageRecord[asciiValue] = true;
			}
		}

		return true;
	}
}
