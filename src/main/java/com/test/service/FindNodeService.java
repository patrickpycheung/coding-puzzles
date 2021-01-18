package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class FindNodeService {

	public LinkedListNode getKthToLastOfNode(LinkedListNode head, int k) {

		// Create 2 nodes separated by k-nodes apart

		LinkedListNode l1 = head;
		LinkedListNode l2 = head;

		for (int i = 0; i < k - 1; i++) {
			if (l2 == null) {
				// The node does not have k elements

				throw new IllegalArgumentException("Insufficient elements in node!");
			}

			l2 = l2.next;
		}

		// Shift l1 and l2 simultaneously, until l2 reaches the end node

		while (l2.next != null) {
			l1 = l1.next;
			l2 = l2.next;
		}

		return l1;
	}
}
