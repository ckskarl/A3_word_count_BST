package structures;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * This is a Binary Search Tree Node class in which a node is created. This node
 * contains data holder and a LinkedList named info that is used to contain
 * various node information. Each node also contains links to a left and right
 * child nodes (or null if there are no child nodes) that allows traversal
 * through the BST.
 * 
 * @author Alex Fleury, Christian Lay, Brandon Donkersloot, Kin Shing Chong
 *
 * @param <E> the type of elements held in this object
 */
public class BSTNode<E> implements Serializable {

	private E data;
	private BSTNode<E> left;
	private BSTNode<E> right;
	LinkedList<E> info = new LinkedList<E>();

	/**
	 * Add any input into the node's info LinkedList.
	 * 
	 * @param input is generic user specified data
	 */
	public void addInfo(E input) {
		this.info.add(input);
	}

	/**
	 * Returns the number of linked elements inside a node's info LinkedList.
	 * 
	 * @return size of the info LinkedList
	 */
	public int getInfoSize() {
		return this.info.size();
	}

	/**
	 * Returns the info LinkedList a node contains.
	 * 
	 * @return info LinkedList list
	 */
	public LinkedList<E> getInfo() {
		return this.info;
	}

	/**
	 * User-defined constructor to create a new BSTNode.
	 * 
	 * @param data Data in node.
	 */
	public BSTNode(E data) {
		this.data = data;
	}

	/**
	 * 3input constructor by kin Nov 28
	 * 
	 * @param data Data in node.
	 * @param left the left node.
	 * @param right the right node.
	 */
	public BSTNode(E data, BSTNode<E> left, BSTNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
		// this.info = new LinkedList<E>();
	}

	/**
	 * Returns the data in the node.
	 * 
	 * @return data
	 */
	public E getData() {
		return data;
	}

	/**
	 * Sets the data in the node based on parameter input.
	 * 
	 * @param data New data
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Returns the right node or null (if there is no next node).
	 * 
	 * @return right node.
	 */
	public BSTNode<E> getRight() {
		return right;
	}

	/**
	 * Sets the right node based on parameter input.
	 * 
	 * @param right New right node.
	 */
	public void setRight(BSTNode<E> right) {
		this.right = right;
	}

	/**
	 * Returns the left node or null (if there is no next node).
	 * 
	 * @return left node.
	 */
	public BSTNode<E> getLeft() {
		return left;
	}

	/**
	 * Sets the left node based on parameter input.
	 * 
	 * @param left New left node.
	 */
	public void setLeft(BSTNode<E> left) {
		this.left = left;
	}

	/**
	 * Returns a boolean value depending on whether the current node has a left
	 * child.
	 * 
	 * @return true if node has a left child, false if node does not.
	 */
	public boolean hasLeftChild() {
		return (this.left != null);
	}

	/**
	 * Returns a boolean value depending on whether the current node has a right
	 * child.
	 * 
	 * @return true if node has a right child, false if node does not.
	 */
	public boolean hasRightChild() {
		return (this.right != null);
	}

	/**
	 * Returns a boolean value depending on whether the current has no child nodes.
	 * 
	 * @return true if node has no left and right node, false if node has left and
	 *         right node.
	 */
	public boolean isLeaf() {
		return (this.right == null && this.left == null);
	}

	/**
	 * Returns the num value of zero.
	 * 
	 * @return num value
	 */
	public int getNumberNodes() {
		int num = 0;
		return num;
	}

	/**
	 * Returns the num value of zero.
	 * 
	 * @return num value
	 */
	public int getHeight() {
		int height = 0;
		return height;
	}

	/**
	 * Returns the num value of zero.
	 * @param theNode target Node
	 * @return num value
	 */
	public int getHeight(BSTNode<E> theNode) {
		int height = 0;
		return height;
	}
}
