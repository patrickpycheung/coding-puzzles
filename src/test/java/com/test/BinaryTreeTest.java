package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.service.binaryTreeService.BinaryTree;
import com.test.service.binaryTreeService.BinaryTreeService;
import com.test.service.binaryTreeService.Node;

@SpringBootTest
public class BinaryTreeTest {

	@Autowired
	private BinaryTreeService binaryTreeService;

	@Test
	public void shouldBeAbleToAddNodesToBinaryTree() {
		BinaryTree binaryTree = new BinaryTree();

		binaryTreeService.addElementToBinaryTree(binaryTree, 6);
		binaryTreeService.addElementToBinaryTree(binaryTree, 3);
		binaryTreeService.addElementToBinaryTree(binaryTree, 9);

		assertEquals(3, binaryTree.getNodeCount());
	}

	@Test
	public void shouldBeAbleToFindNodeFromBinaryTree() {
		BinaryTree binaryTree = new BinaryTree();

		binaryTreeService.addElementToBinaryTree(binaryTree, 6);
		binaryTreeService.addElementToBinaryTree(binaryTree, 3);
		binaryTreeService.addElementToBinaryTree(binaryTree, 9);

		Node node = binaryTreeService.findElementInBinaryTree(binaryTree, 3);
		assertEquals(3, node.getValue());
	}

	@Test
	public void shouldBeAbleToGetAListOfAllNodesAtEachDepthOfABinaryTree() {
		BinaryTree binaryTree = new BinaryTree();

		binaryTreeService.addElementToBinaryTree(binaryTree, 7);
		binaryTreeService.addElementToBinaryTree(binaryTree, 2);
		binaryTreeService.addElementToBinaryTree(binaryTree, 9);
		binaryTreeService.addElementToBinaryTree(binaryTree, 1);
		binaryTreeService.addElementToBinaryTree(binaryTree, 5);
		binaryTreeService.addElementToBinaryTree(binaryTree, 14);

		// Actual result

		List<List<Integer>> listOfListOfNodes = binaryTreeService.getListOfListOfNodes(binaryTree);

		// Expected result

		List<Integer> zeroDepthList = new LinkedList<>();
		zeroDepthList.add(7);
		List<Integer> oneDepthList = new LinkedList<>();
		oneDepthList.add(2);
		oneDepthList.add(9);
		List<Integer> secondDepthList = new LinkedList<>();
		secondDepthList.add(1);
		secondDepthList.add(5);
		secondDepthList.add(14);

		List<List<Integer>> expectedListOfList = new LinkedList<>();

		expectedListOfList.add(zeroDepthList);
		expectedListOfList.add(oneDepthList);
		expectedListOfList.add(secondDepthList);

		// Assertion

		assertEquals(expectedListOfList, listOfListOfNodes);
	}

	@Test
	public void shoudlBeAbleToCheckIfABinaryTreeIsBalanced() {
		BinaryTree binaryTree = new BinaryTree();

		boolean result;

		// Case 1:
		// Only have root node

		binaryTree = new BinaryTree();
		binaryTreeService.addElementToBinaryTree(binaryTree, 5);

		result = binaryTreeService.isBinaryTreeBalanced(binaryTree);

		assertTrue(result);

		// Case 2:
		// Left node is 1-height larger

		binaryTree = new BinaryTree();
		binaryTreeService.addElementToBinaryTree(binaryTree, 5);
		binaryTreeService.addElementToBinaryTree(binaryTree, 4);

		result = binaryTreeService.isBinaryTreeBalanced(binaryTree);

		assertTrue(result);

		// Case 3:
		// Right node is 1-height larger

		binaryTree = new BinaryTree();
		binaryTreeService.addElementToBinaryTree(binaryTree, 5);
		binaryTreeService.addElementToBinaryTree(binaryTree, 6);

		result = binaryTreeService.isBinaryTreeBalanced(binaryTree);

		assertTrue(result);

		// Case 4:
		// Left and right node both at height of 2

		binaryTree = new BinaryTree();
		binaryTreeService.addElementToBinaryTree(binaryTree, 5);
		binaryTreeService.addElementToBinaryTree(binaryTree, 4);
		binaryTreeService.addElementToBinaryTree(binaryTree, 6);

		result = binaryTreeService.isBinaryTreeBalanced(binaryTree);

		assertTrue(result);

		// Case 5:
		// Left node at height of 3 (Incomplete node), right node at height of 2

		binaryTree = new BinaryTree();
		binaryTreeService.addElementToBinaryTree(binaryTree, 5);
		binaryTreeService.addElementToBinaryTree(binaryTree, 4);
		binaryTreeService.addElementToBinaryTree(binaryTree, 6);
		binaryTreeService.addElementToBinaryTree(binaryTree, 3);

		result = binaryTreeService.isBinaryTreeBalanced(binaryTree);

		assertTrue(result);

		// Case 6:
		// Right node at height of 3 (Incomplete node), left node at height of 2

		binaryTree = new BinaryTree();
		binaryTreeService.addElementToBinaryTree(binaryTree, 5);
		binaryTreeService.addElementToBinaryTree(binaryTree, 4);
		binaryTreeService.addElementToBinaryTree(binaryTree, 6);
		binaryTreeService.addElementToBinaryTree(binaryTree, 7);

		result = binaryTreeService.isBinaryTreeBalanced(binaryTree);

		assertTrue(result);

		// Case 7:
		// Left node at height of 3 (Complete node), right node at height of 2

		binaryTree = new BinaryTree();
		binaryTreeService.addElementToBinaryTree(binaryTree, 5);
		binaryTreeService.addElementToBinaryTree(binaryTree, 3);
		binaryTreeService.addElementToBinaryTree(binaryTree, 7);
		binaryTreeService.addElementToBinaryTree(binaryTree, 2);
		binaryTreeService.addElementToBinaryTree(binaryTree, 4);

		result = binaryTreeService.isBinaryTreeBalanced(binaryTree);

		assertTrue(result);

		// Case 8:
		// Right node at height of 3 (Complete node), left node at height of 2

		binaryTree = new BinaryTree();
		binaryTreeService.addElementToBinaryTree(binaryTree, 5);
		binaryTreeService.addElementToBinaryTree(binaryTree, 3);
		binaryTreeService.addElementToBinaryTree(binaryTree, 7);
		binaryTreeService.addElementToBinaryTree(binaryTree, 6);
		binaryTreeService.addElementToBinaryTree(binaryTree, 8);

		result = binaryTreeService.isBinaryTreeBalanced(binaryTree);

		assertTrue(result);

		// Case 9:
		// Left node at height of 4, right node at height of 2

		binaryTree = new BinaryTree();
		binaryTreeService.addElementToBinaryTree(binaryTree, 5);
		binaryTreeService.addElementToBinaryTree(binaryTree, 3);
		binaryTreeService.addElementToBinaryTree(binaryTree, 7);
		binaryTreeService.addElementToBinaryTree(binaryTree, 2);
		binaryTreeService.addElementToBinaryTree(binaryTree, 1);

		result = binaryTreeService.isBinaryTreeBalanced(binaryTree);

		assertFalse(result);

		// Case 10:
		// Right node at height of 4, left node at height of 2

		binaryTree = new BinaryTree();
		binaryTreeService.addElementToBinaryTree(binaryTree, 5);
		binaryTreeService.addElementToBinaryTree(binaryTree, 3);
		binaryTreeService.addElementToBinaryTree(binaryTree, 7);
		binaryTreeService.addElementToBinaryTree(binaryTree, 8);
		binaryTreeService.addElementToBinaryTree(binaryTree, 9);

		result = binaryTreeService.isBinaryTreeBalanced(binaryTree);

		assertFalse(result);

	}
}
