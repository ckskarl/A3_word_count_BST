package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import structures.Word;
import exceptions.TreeException;
import structures.BSTNode;
import structures.BSTReferencedBased;
import utilities.Iterator;

public class BSTReferencedBasedTest {
	
	private BSTReferencedBased one;
	private BSTReferencedBased two;

	

	@Before
	public void setUp() throws Exception {
		one = new BSTReferencedBased<>();
		two = new BSTReferencedBased<>();
	}

	@After
	public void tearDown() throws Exception {
		one = null;
		two = null;
	}



	@Test
	public void testGetRoot() {
		BSTNode expected = new BSTNode("pass");
		one.add("pass");
		one.add("fail");
		one.add("button");
		BSTNode actual = null;
		try {
			actual = one.getRoot();
		} catch (TreeException e) {
			e.printStackTrace();
		}
		assertEquals("getRoot method did not return the root node ", expected.getData(), actual.getData());
	}

	@Test
	public void testGetHeight() {
		int expected = 4;
		one.add("I");
		one.add("D");
		one.add("M");
		one.add("C");
		one.add("E");
		one.add("B");
		int actual = one.getHeight();
		assertEquals("getHeight method did not return the proper height ", expected, actual);
	}

	@Test
	public void testSize() {
		int expected = 3;
		one.add("button");
		one.add("act");
		one.add("cat");
		int actual = one.size();
		assertEquals("Size method did not return the proper size ", expected, actual);
	}

	@Test
	public void testIsEmpty() {
		
		
		assertTrue("the isEmpty method did not evaluate the stack correctly", one.isEmpty());


	}

	@Test
	public void testClear() {
		one.add("button");
		one.add("act");
		one.add("cat");
		one.clear();
		assertTrue("the clear method did notempty the tree", one.isEmpty());
	}

	@Test
	public void testContains() {
		
		one.add("button");
		one.add("act");
		one.add("cat");
		one.add("lol");
		one.add("catfish");
		one.add("toot");
		one.add("fat");
		one.add("skin");
		one.add("eye");
		try {
			assertTrue("the contains method did not evaluate the tree correctly", one.contains("catfish"));
		} catch (TreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testSearch() {
		
		BSTNode expected = new BSTNode("fat");
		one.add("button");
		one.add("act");
		one.add("cat");
		one.add("lol");
		one.add("catfish");
		one.add("toot");
		one.add("fat");
		one.add("skin");
		one.add("eye");
		BSTNode actual = null;
		try {
			actual = one.search("fat");
		} catch (TreeException e) {
			e.printStackTrace();
		}

		
		assertEquals("search method did not return the proper result ", expected.getData(), actual.getData());
	}

	@Test
	public void testAddRight() {
		String expected = "E";
		
		one.add("I");
		one.add("D");
		one.add("M");
		one.add("C");
		one.add("E");
		one.add("B");
		String actual = null;
		try {
			actual = (String) one.getRoot().getLeft().getRight().getData();
		} catch (TreeException e) {
			e.printStackTrace();
		}
		assertEquals("getRoot method did not return the root node ", expected, actual);
		
	}
	
	@Test
	public void testAddLeft() {
		String expected = "B";
		
		one.add("I");
		one.add("D");
		one.add("M");
		one.add("C");
		one.add("E");
		one.add("B");
		String actual = null;
		try {
			actual = (String) one.getRoot().getLeft().getLeft().getLeft().getData();
		} catch (TreeException e) {
			e.printStackTrace();
		}
		assertEquals("getRoot method did not return the root node ", expected, actual);
		
	}
	
	@Test
	public void testAddRightRight() {
		String expected = "P";
		
		one.add("I");
		one.add("D");
		one.add("M");
		one.add("C");
		one.add("E");
		one.add("B");
		one.add("L");
		one.add("Q");
		one.add("P");
		String actual = null;
		try {
			actual = (String) one.getRoot().getRight().getRight().getLeft().getData();
		} catch (TreeException e) {
			e.printStackTrace();
		}
		assertEquals("getRoot method did not return the root node ", expected, actual);
		
	}

	@Test
	public void testInorderIterator() {
		int[] numbers = {1, 3, 4, 6, 7, 8, 10, 13, 14};
		one.add(8);
		one.add(3);
		one.add(10);
		one.add(1);
		one.add(6);
		one.add(14);
		one.add(4);
		one.add(7);
		one.add(13);
		Iterator<Word> it = one.inorderIterator();
		int count = 0;
		while (it.hasNext()) {
			assertEquals("InorderIterator method is not working ", numbers[count], it.next());
			count++;
		}
		
	}

	@Test
	public void testPreorderIterator() {
		int[] numbers = {8, 3, 1, 6, 4, 7, 10, 14, 13};
		one.add(8);
		one.add(3);
		one.add(10);
		one.add(1);
		one.add(6);
		one.add(14);
		one.add(4);
		one.add(7);
		one.add(13);
		Iterator<Word> it = one.preorderIterator();
		int count = 0;
		while (it.hasNext()) {
			assertEquals("PreorderIterator method is not working ", numbers[count], it.next());
			count++;
		}
	}

	@Test
	public void testPostorderIterator() {
		int[] numbers = {1, 4, 7, 6, 3, 13, 14, 10, 8};
		one.add(8);
		one.add(3);
		one.add(10);
		one.add(1);
		one.add(6);
		one.add(14);
		one.add(4);
		one.add(7);
		one.add(13);
		Iterator<Word> it = one.postorderIterator();
		int count = 0;
		while (it.hasNext()) {
			assertEquals("PostorderIterator method is not working ", numbers[count], it.next());
			count++;
		}
	}

}
