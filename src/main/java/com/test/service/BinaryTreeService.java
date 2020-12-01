package com.test.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.BinaryTree;
import com.test.model.Node;

@Service
public class BinaryTreeService {

	@Autowired
	private BinaryTree binaryTree;

	List<List<Integer>> listOfListOfNodes = new LinkedList<>();

	public void addElementToBinaryTree(int i) {
		binaryTree.setRootNode(addRecursive(binaryTree.getRootNode(), i));
	}

	private Node addRecursive(Node node, int i) {
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
			node.setLeftNode(addRecursive(node.getLeftNode(), i));
		} else {
			node.setRightNode(addRecursive(node.getRightNode(), i));
		}

		return node;
	}

	public Node findElementInBinaryTree(int i) {
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

	public List<List<Integer>> getListOfListOfNodes() {
		listOfListOfNodes = new LinkedList<>();
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
}
