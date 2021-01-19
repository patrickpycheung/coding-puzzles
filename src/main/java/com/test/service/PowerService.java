package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class PowerService {

	public boolean isPowerOfTwo(int num) {

		if (Math.log(num) % Math.log(2) == 0) {
			return true;
		}

		return false;
	}
}
