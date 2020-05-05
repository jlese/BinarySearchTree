import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
	BinarySearchTree<Integer> newTree;
	BinarySearchTree<Integer> newTree2;
	BinaryTreeNode<Integer> node1;

	@Before
	public void setUp() {

	}

	@Test
	public void testSize1() {
		// create test node and tree
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(7);
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>(node1);

		// create result
		int actual = newTree.size();

		// test on non-empty tree
		assertEquals(1, actual);
	}

	@Test
	public void testSize2() {
		// create test node and tree
		BinarySearchTree<Integer> newTree2 = new BinarySearchTree<Integer>();

		// test on empty tree
		assertEquals(newTree2.size(), 0);
	}

	@Test
	public void testHeight1() {
		// create test node and tree
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(7);
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>(node1);

		// create result
		int actual = newTree.height();

		// test for non-empty tree
		assertEquals(1, actual);
	}

	@Test
	public void testHeight2() {
		// create test node and tree
		BinarySearchTree<Integer> newTree2 = new BinarySearchTree<Integer>();

		// create result
		int actual = newTree2.height();

		// test for empty tree
		assertEquals(0, actual);
	}

	@Test
	public void testInsert1() {
		// create test node and tree
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(7);
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>(node1);

		// test for successful insert
		assertTrue(newTree.insert(9));
	}

	@Test
	public void testInsert2() {
		// create test node and tree
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(7);
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>(node1);

		// test for failed insert w/ duplicate
		assertFalse(newTree.insert(7));
	}

	@Test
	public void testFind1() {
		// create test node and tree
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(7, node1, node2);
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>(root);

		// test for successful find
		assertTrue(newTree.find(2));
	}

	@Test
	public void testFind2() {
		// create test node and tree
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(7, node1, node2);
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>(root);

		// test for failed find
		assertFalse(newTree.find(0));
	}

	@Test
	public void testInOrder1() {
		// create test node and tree
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(7, node1, node2);
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>(root);

		// test for non-empty tree
		assertEquals("(2)(7)(9)", newTree.inOrder());
	}

	@Test
	public void testInOrder2() {
		// create test node and tree
		BinarySearchTree<Integer> newTree2 = new BinarySearchTree<Integer>();

		// test for empty tree
		assertEquals("", newTree2.inOrder());
	}

	@Test
	public void testPostOrder1() {
		// create test node and tree
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(7, node1, node2);
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>(root);

		// test for non-empty tree
		assertEquals("(2)(9)(7)", newTree.postOrder());
	}

	@Test
	public void testPostOrder2() {
		// create test node and tree
		BinarySearchTree<Integer> newTree2 = new BinarySearchTree<Integer>();

		// test for empty tree
		assertEquals("", newTree2.postOrder());
	}

	@Test
	public void testToString1() {
		// create test node and tree
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(7, node1, node2);
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>(root);

		// test for non-empty tree
		assertEquals(newTree.inOrder(), newTree.toString());
	}

	@Test
	public void testToString2() {
		// create test node and tree
		BinarySearchTree<Integer> newTree2 = new BinarySearchTree<Integer>();

		// test for empty tree
		assertEquals(newTree2.inOrder(), newTree2.toString());
	}

	@Test
	public void testBuildFromList1() {
		// create list to build from
		ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(9, 2, 8, 1, 11, 10));

		// create pre-existing tree
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(7, node1, node2);
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>(root);

		// chop down old tree and build new one
		newTree.buildFromList(list1);

		// test for successful build
		assertEquals("(1)(8)(2)(10)(11)(9)", newTree.postOrder());
	}

	@Test
	public void testBuildFromList2() {
		// create list to build from with duplicates
		ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(9, 2, 2, 8, 4, 5, 6));
		BinarySearchTree<Integer> newTree2 = new BinarySearchTree<Integer>();

		// test for failed build b/c of duplicates
		assertFalse(newTree2.buildFromList(list1));
	}

}
