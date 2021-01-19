package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	private BinaryTree binaryTree;

	@Autowired
	private BinaryTreeService binaryTreeService;

	@Test
	public void shouldBeAbleToAddNodesToBinaryTree() {
		binaryTreeService.addElementToBinaryTree(6);
		binaryTreeService.addElementToBinaryTree(3);
		binaryTreeService.addElementToBinaryTree(9);

		assertEquals(3, binaryTree.getNodeCount());
	}

	@Test
	public void shouldBeAbleToFindNodeFromBinaryTree() {

		binaryTreeService.addElementToBinaryTree(6);
		binaryTreeService.addElementToBinaryTree(3);
		binaryTreeService.addElementToBinaryTree(9);

		Node node = binaryTreeService.findElementInBinaryTree(3);
		assertEquals(3, node.getValue());
	}

	@Test
	public void shouldBeAbleToGetAListOfAllNodesAtEachDepthOfABinaryTree() {

		binaryTreeService.addElementToBinaryTree(7);
		binaryTreeService.addElementToBinaryTree(2);
		binaryTreeService.addElementToBinaryTree(9);
		binaryTreeService.addElementToBinaryTree(1);
		binaryTreeService.addElementToBinaryTree(5);
		binaryTreeService.addElementToBinaryTree(14);

		// Actual result

		List<List<Integer>> listOfListOfNodes = binaryTreeService.getListOfListOfNodes();

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
}
