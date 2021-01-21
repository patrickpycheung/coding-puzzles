package com.test.service.binaryTreeService;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BinaryTreeService {

	private List<List<Integer>> listOfListOfNodes = new LinkedList<>();

	// Initial maxHeight is height of the root node
	private int maxHeight = 1;

	public void addElementToBinaryTree(BinaryTree binaryTree, int i) {
		binaryTree.setRootNode(addRecursive(binaryTree, binaryTree.getRootNode(), i));
		return;
	}

	private Node addRecursive(BinaryTree binaryTree, Node node, int i) {
		if (node == null) {
			// Add new node
			Node newNode = new Node();
			newNode.setValue(i);
			// Update the node count
			binaryTree.setNodeCount(binaryTree.getNodeCount() + 1);
			return newNode;
		}

		// Current node exist, can't store at this node, we need to add child node

		if (i < node.getValue()) {
			node.setLeftNode(addRecursive(binaryTree, node.getLeftNode(), i));
		} else {
			node.setRightNode(addRecursive(binaryTree, node.getRightNode(), i));
		}

		return node;
	}

	public Node findElementInBinaryTree(BinaryTree binaryTree, int i) {
		Node node = findRecursive(binaryTree.getRootNode(), i);
		return node;
	}

	private Node findRecursive(Node node, int i) {
		if (i == node.getValue()) {
			// Found the element at this node
			return node;
		}

		// Not found in current node, go to search child node

		if (i < node.getValue()) {
			if (node.getLeftNode() == null) {
				// Left node does not exist, means element not found

				// Return the empty node
				return node.getLeftNode();
			}

			node = findRecursive(node.getLeftNode(), i);
		} else {
			if (node.getRightNode() == null) {
				// Right node does not exist, means element not found

				// Return the empty node
				return node.getRightNode();
			}

			node = findRecursive(node.getRightNode(), i);
		}

		return node;
	}

	public List<List<Integer>> getListOfListOfNodes(BinaryTree binaryTree) {
		// Root node would have node depth of 0
		getListOfNodeRecursive(binaryTree.getRootNode(), 0);
		return listOfListOfNodes;
	}

	private void getListOfNodeRecursive(Node node, int nodeDepth) {

		// Ensure that there is enough lists to handle operation at current depth
		// e.g. At node depth of 0, there should be at least 1 list of node
		if (!(listOfListOfNodes.size() >= (nodeDepth + 1))) {
			List<Integer> intList = new LinkedList<>();
			listOfListOfNodes.add(intList);
		}

		// Handle current left node
		if (node.getLeftNode() != null) {
			// Left node exists
			// Go down 1 depth to handle the left node
			getListOfNodeRecursive(node.getLeftNode(), nodeDepth + 1);
		}

		// Add the current parent node to list
		listOfListOfNodes.get(nodeDepth).add(node.getValue());

		// Handle current right node
		if (node.getRightNode() != null) {
			// Right node exists
			// Go down 1 depth to handle the right node
			getListOfNodeRecursive(node.getRightNode(), nodeDepth + 1);
		}
	}

	public boolean isBinaryTreeBalanced(BinaryTree binaryTree) {
		// Initialize maxHeight;
		maxHeight = 1;

		Node rootNode = binaryTree.getRootNode();

		// Default height of both sides is 1 which is the height of the root node
		int leftHeight = 1;
		int rightHeight = 1;

		if (rootNode.getLeftNode() != null) {
			// Left child exist

			// Add left child height
			maxHeight++;

			findLargestHeightRecursive(rootNode.getLeftNode());
			leftHeight = maxHeight;
		}

		// Reset maxHeight
		maxHeight = 1;

		if (rootNode.getRightNode() != null) {
			// Right child exist

			// Add right child height
			maxHeight++;

			findLargestHeightRecursive(rootNode.getRightNode());
			rightHeight = maxHeight;
		}

		// Comparison
		if (Math.abs(leftHeight - rightHeight) > 1) {
			// Height difference over limit

			return false;
		}

		return true;
	}

	private void findLargestHeightRecursive(Node node) {

		if (node.getLeftNode() == null && node.getRightNode() == null) {
			// No more children under this node

			return;
		}

		if (node.getLeftNode() != null) {
			// Left child exists

			findLargestHeightRecursive(node.getLeftNode());
		}

		if (node.getRightNode() != null) {
			// Right child exists

			findLargestHeightRecursive(node.getRightNode());
		}

		if (node.getLeftNode() != null || node.getRightNode() != null) {
			// This node has either or both of left child / right child

			// Add current node to height
			maxHeight++;
		}

	}
}
