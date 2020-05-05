import java.util.ArrayList;


/**
 * Binary Search Tree Class
 * 
 * The head class for a binary search tree implementation.
 * 
 * @author YOURID
 * @param <Comparable> Type of data to store in the binary tree
 */
public class BinarySearchTree<T extends Comparable<T>> {

	/**
	 * A reference pointer to the root of the tree
	 */
	private BinaryTreeNode<T> root;

	/**
	 * Default constructor
	 * 
	 * Creates a binary tree object with null root note (empty tree)
	 */
	public BinarySearchTree() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * Creates a binary tree object with the given node as root
	 * 
	 * @param newRoot The root of the tree
	 */
	public BinarySearchTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}

	/**
	 * Get the root of the tree
	 * 
	 * @return The root of the tree
	 */
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * Set the root of the tree
	 * 
	 * @param root The new root of this tree
	 */
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	/**
	 * Returns the size of the tree (that is, the number of nodes in the tree).
	 * 
	 * @return int size | size of tree
	 */
	public int size() {
		int size = 0; // create variable for base case

		if (this.getRoot() != null) {
			size = this.getRoot().size(); // recursive case
		}

		return size;
	}

	/**
	 * Returns the height of the tree.
	 *
	 */
	public int height() {
		int height = 0; // create variable for base case

		if (root == null) { // base case
			return height;
		} else { // recursive case
			return root.height();
		}

	}

	/**
	 * Find if an element exists
	 * 
	 * Checks to see if the value val appears in the tree (recursively). Returns
	 * true if it appears and false otherwise.
	 * 
	 * @param val The value to find
	 * @return True if the tree contains the value, false otherwise
	 */
	public boolean find(T val) {
		BinaryTreeNode<T> current = root;

		while (current != null) { // continue loop until null node is reached
			int retVal = current.getData().compareTo(val); // create comparison value

			if (retVal == 0) { // node found
				return true;
			} else if (retVal > 0) { // recursive left subtree
				current = current.getLeft();
			} else { // recursive right subtree
				current = current.getRight();
			}
		}

		return false; // was not found
	}

	/**
	 * Insert an element
	 * 
	 * Inserts val into the tree where it should appear, returning true on success
	 * and false otherwise
	 * 
	 * @param val The value to insert
	 * @return True on success, false otherwise
	 */
	public boolean insert(T val) {
		if (this.getRoot() == null) { // base case
			this.setRoot(new BinaryTreeNode<T>(val));
			return true;
		} else {
			return this.getRoot().insert(val); // recursive case
		}

	}

	/**
	 * Return a string that represents the data held at each node following the
	 * rules of an in-order traversal.
	 * 
	 * Covered in class Wednesday, April 22
	 */
	public String inOrder() {
		String output = "";

		if (this.root != null) {
			output += this.getRoot().inOrder();
		}

		return output;

	}

	/**
	 * Return a string that represents the data held at each node following the
	 * rules of a post-order traversal.
	 * 
	 * Covered in class Wednesday, April 22
	 */
	public String postOrder() {
		String output = "";

		if (this.root != null) {
			output += this.getRoot().postOrder();
		}

		return output;
	}

	/**
	 * Build from a list
	 * 
	 * Build the tree from the given list, overwriting any tree data previously
	 * stored in this tree. Should read from beginning to end of the list and
	 * repeatedly call insert() to build the tree
	 * 
	 * If the tree is not empty when this method is called, you should empty the
	 * tree before adding any elements in list.
	 *
	 * @param list The list from which to build the tree
	 * @return True if successfully built, false otherwise
	 */
	public boolean buildFromList(ArrayList<T> list) {

		if (!list.isEmpty()) { // check for empty list

			this.setRoot(null); // chop down tree and yank the roots

			BinaryTreeNode<T> root = new BinaryTreeNode<T>(list.get(0)); // set root as first element in list
			this.setRoot(root);

			for (int i = 1; i < list.size(); i++) { // iterate through every other element
				boolean result = this.insert(list.get(i)); // insert element
				if (result) { // insert success, continue
					continue;
				} else { // element was a duplicate, build failed
					return false;
				}
			}
		} else {
			return false;
		}

		return false;

	}

	/**
	 * toString method
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.inOrder(); // returns inOrder string
	}

	/**
	 * Main method
	 * 
	 * For testing, etc
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {

	}
}
