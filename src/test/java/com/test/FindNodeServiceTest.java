package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.service.FindNodeService;
import com.test.service.LinkedListNode;

@SpringBootTest
public class FindNodeServiceTest {

	@Autowired
	private FindNodeService findNodeService;

	@Test
	public void shouldBeAbleToFindTheKthToLastNode() {

		// Input
		LinkedListNode node = new LinkedListNode();
		node.value = 2;

		node.next = new LinkedListNode();
		node.next.value = 3;

		node.next.next = new LinkedListNode();
		node.next.next.value = 5;

		LinkedListNode resultNode = findNodeService.getKthToLastOfNode(node, 2);

		assertEquals(resultNode.value, 3);
		assertEquals(resultNode.next.value, 5);
		assertEquals(resultNode.next.next, null);
	}

	@Test
	public void shouldBeAbleToThrowExceptionOnInsufficientElementCount() {

		// Input
		LinkedListNode node = new LinkedListNode();
		node.value = 2;

		node.next = new LinkedListNode();
		node.next.value = 3;

		node.next.next = new LinkedListNode();
		node.next.next.value = 5;

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			findNodeService.getKthToLastOfNode(node, 5);
		});
		assertEquals("Insufficient elements in node!", exception.getMessage());
	}
}
