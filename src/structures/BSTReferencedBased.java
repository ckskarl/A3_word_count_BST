package structures;


import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.*;

import exceptions.TreeException;
import utilities.BSTreeADT;
import utilities.Iterator;

/**
 * Binary Search Tree base on TSTreeADT
 * It provides all the essential methods for binary searcg tree data structure 
 * @author Kin Shing Chong, Chirstian Lay, Alex Fleury, Brandon Donkersloot
 * @version 01/12/2021
 */
public class   BSTReferencedBased <E extends Comparable<? super E>> implements BSTreeADT <E> {

	int size;
	int height;
	BSTNode<E> root;


	/**
	 * The default constructor
	 */
	public BSTReferencedBased() {
		this.size = 0;
		this.height = 0;
	}


	/**
	 * The node at the root of the Binary Search Tree will be returned.
	 * @return node stored at the root of tree is returned
	 * @throws TreeException if the root is empty.
	 */
	@Override
	public BSTNode<E> getRoot() throws TreeException {
		return root;
	}

	/**
	 * Determines the height of row of the tree and returns it as an integer value
	 * @return the height of the tree.
	 */
	@Override
	public int getHeight() {
		return height;
	}

	/**
	 * The number of elements currently stored in the tree is counted and the value is returned.
	 * @return number of elements currently stored in tree.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Checks if the tree is currently empty.
	 * @return returns boolean true if the tree is empty otherwise false.
	 */
	@Override
	public boolean isEmpty() {
		if (this.size > 0 ) {
			return false;
		}
		return true;
	}


	/**
	 * Clears all elements currently stored in tree and makes the tree empty.
	 */
	@Override
	public void clear() {
		this.root = null;
		this.size = 0;
		this.height = 0;

	}

	/**
	 * Checks the current tree to see if the element passed in is stored in
	 * the tree. If the element is found in the tree the method returns true
	 * and if the element is not in the tree the method returns false.
	 * @param entry the element to find in the tree
	 * @return returns boolean true if element is currently in the tree and false if the element is not found in the tree
	 * @throws TreeException if the tree is empty.
	 */
	@Override
	public boolean contains(E entry) throws TreeException {
		BSTNode<E> temp = root;

		while (temp != null) {
			if ((entry.compareTo((E) temp.getData())) == 0) {
				return true;
			}
			if ((((Comparable<? super E>) temp.getData()).compareTo((E) entry)) > 0) {
				temp = temp.getLeft();
			}
			if((((Comparable<? super E>) temp.getData()).compareTo((E) entry))< 0) {
				temp = temp.getRight();
			}
		}
		return false;
	}

	/**
	 * Retrieves a node from the tree given the object to search for.
	 * @param entry element object being searched
	 * @return the node with the element located in tree, null if not found
	 * @throws TreeException if the tree is empty
	 */
	@Override
	public BSTNode<E> search(E entry) throws TreeException {
		BSTNode<E> temp = root;
		while (temp != null) {
			if (temp.getData().compareTo((E) entry) == 0) {

				return temp;
			}
			else if ((((Comparable<? super E>) temp.getData()).compareTo((E) entry)) > 0) {
				temp = temp.getLeft();
			}
			else if ((((Comparable<? super E>) temp.getData()).compareTo((E) entry))  < 0) {
				temp = temp.getRight();
			}
		}
		return null;
	}


	/**
	 * Adds a new element to the tree according to the natural ordering
	 * established by the Comparable implementation.
	 * @param newEntry the element being added to the tree
	 * @return a boolean true if the element is added successfully else false
	 * @throws NullPointerException if the element being added is null
	 */
	@Override
	public boolean add(E newEntry) throws NullPointerException {
		BSTNode<E> newNode = new BSTNode<E>(newEntry);
		newNode.addInfo(newEntry);
		if (root == null) {
			root = newNode;
			size++;
			height++;
			return true;
		}
		BSTNode<E> current = root;
		BSTNode<E> parent = null;
		int heightCount = 1;
		while (true) {
			parent = current;
			if ((newEntry.compareTo((E) current.getData())) < 0) {
				current = current.getLeft();
				heightCount++;
				if (current == null) {
					parent.setLeft(newNode);
					size++;
					if (parent.getRight() == null && heightCount > height) {
						height++;
					}
					return true;
				}
			}
			else {
				current = current.getRight();
				heightCount++;
				if (current == null) {
					parent.setRight(newNode);
					size++;
					if (parent.getLeft() == null && heightCount > height) {
						height++;
					}
					return true;
				}
			}
		}

	}

	/**
	 * Generates an in-order iteration over the contents of the tree. 
	 * Elements are in their natural order.(such as alphabetical)
	 * @return an iterator with the elements in the natural order
	 */
	@SuppressWarnings("null")
	@Override
	public Iterator<E> inorderIterator() {
		Stack<BSTNode<E>> inorderTraversalStack = new Stack<BSTNode<E>>();
		Deque<BSTNode<E>> forDisplay = new LinkedList<BSTNode<E>>();
		BSTNode<E> current=root;
		while (current!=null || inorderTraversalStack.size() >0) {
			while (current!=null) {
				inorderTraversalStack.push(current);
				current=current.getLeft();
			}
			forDisplay.add(inorderTraversalStack.peek());
			current=inorderTraversalStack.pop();
			//System.out.println("BST Stack (inorder): " + current.getData().toString());
			current=current.getRight();
		}


		Iterator<E> it = new Iterator<E>() {

			//private int index = postorderTraversalStack.size()-1;

			@Override
			public boolean hasNext() { 
				return !forDisplay.isEmpty();
			}


			@SuppressWarnings("unchecked")
			@Override
			public E next() throws NoSuchElementException {
				if(!hasNext()) throw new NoSuchElementException();
				return (E)forDisplay.remove().getData();
			}
		};
		return it;

	}

	/**
	 * Generates a pre-order iteration over the contents of the tree. Elements
	 * are order in such a way as the root element is first.
	 * @return an iterator with the elements in a root element first order
	 */
	@Override
	public Iterator<E> preorderIterator() {
		Iterator<E> it = new Iterator<E>() {
			int sizeCount = 0;

			@Override
			public boolean hasNext() {
				return sizeCount < size;
			}

			@Override
			public E next() throws NoSuchElementException {
				if(!hasNext()) throw new NoSuchElementException();
				Stack<BSTNode<E>> preorderTraversalStack = new Stack<BSTNode<E>>();
				Queue<BSTNode<E>> inorderTraversalQueue = new LinkedList<BSTNode<E>>();
				BSTNode<E> current=root;
				if (current!=null) {
					preorderTraversalStack.push(current);
				}
				while ( preorderTraversalStack.size() >0) {
					current=preorderTraversalStack.peek();
					System.out.println("BST Stack (preorder): " + current.getData().toString());
					preorderTraversalStack.pop();
					inorderTraversalQueue.add(current);
					sizeCount++;
					if (current.hasRightChild()) {
						preorderTraversalStack.push(current.getRight());
					}
					if (current.hasLeftChild()) {
						preorderTraversalStack.push(current.getLeft());
					}
				}
				return (E)inorderTraversalQueue.remove().getData();
			}
		};
		return it;
	}
	
	/**
	 * Generates a post-order iteration over the contents of the tree. Elements
	 * are order in such a way as the root element is last.
	 * @return an iterator with the elements in a root element last order
	 */
	@Override
	public Iterator<E> postorderIterator() {
		Stack<BSTNode<E>> postorderTraversalStack = new Stack<BSTNode<E>>();
		Stack<BSTNode<E>> L = new Stack<BSTNode<E>>();
		Stack<BSTNode<E >> R = new Stack<BSTNode<E>>();

		BSTNode<E> node = root;

		System.out.println(node.getData());
		while (postorderTraversalStack.size()<size) {

			if (!L.contains(node)) {
				L.push(node);
				node = node.getLeft();
				if (node == null) {
					node = L.peek();
				}
			} 
			else if (R.contains(node)) {
				postorderTraversalStack.push(node);
				System.out.println("BST Stack (postorder): " + postorderTraversalStack.peek().getData().toString());
				L.pop();
				R.pop();
				if (!L.isEmpty()) {
					node = L.peek();
				}
			}
			else {
				R.push(node);
				node = node.getRight();
				if (node == null) {
					node = R.peek();

				}
			}		
		}
		Iterator<E> it = new Iterator<E>() {


			@Override
			public boolean hasNext() {

				return postorderTraversalStack.isEmpty();
			}


			@Override
			public E next() throws NoSuchElementException {
				if(!hasNext()) throw new NoSuchElementException();
				return (E)postorderTraversalStack.pop();
			}
		};
		return it;

	}

}
