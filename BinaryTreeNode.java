import java.util.LinkedList;


/**
 * Binary Tree Node
 * 
 * Tree node that has two children: left and right
 * 
 * @author Jack Lesemann | jwl4vg
 * @param <Comparable> The type of data this tree node stores
 */
public class BinaryTreeNode<T extends Comparable<T>> {

	/**
	 * Reference pointer to the left subtree
	 */
	private BinaryTreeNode<T> left;

	/**
	 * Reference pointer to the right subtree
	 */
	private BinaryTreeNode<T> right;

	/**
	 * Data stored at this node
	 */
	private T data;

	/**
	 * Default Constructor
	 * 
	 * Creates a binary tree node with null data and null children
	 */
	public BinaryTreeNode() {
		this(null, null, null);
	}

	/**
	 * Data-only Constructor
	 * 
	 * Creates a binary tree node with the given data and null children
	 * 
	 * @param theData The data to store at this node
	 */
	public BinaryTreeNode(T theData) {
		this(theData, null, null);
	}

	/**
	 * Full Constructor
	 * 
	 * Creates a binary tree node with the given data and child reference pointers
	 * 
	 * @param theData    The data to store at this node
	 * @param leftChild  A reference pointer to the left subtree
	 * @param rightChild A reference pointer to the right subtree
	 */
	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	/**
	 * Left Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the left subtree
	 */
	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	/**
	 * Left Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new left subtree's root node
	 */
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	/**
	 * Right Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the right subtree
	 */
	public BinaryTreeNode<T> getRight() {
		return right;
	}

	/**
	 * Right Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new right subtree's root node
	 */
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	/**
	 * Get the data at this node
	 * 
	 * @return The data stored at this node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set the data at this node
	 * 
	 * @param data The data to be stored at this node
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return null;
	}

	/**
	 * Node-level size method Recursively gets size of tree
	 * 
	 * @return size | int of # nodes in tree
	 */
	public int size() {
		int size = 0;

		if (this.getLeft() != null) {
			size = size + this.getLeft().size(); // recursively call on next child (left)
		}

		if (this.getRight() != null) {
			size = size + this.getRight().size(); // recursively call on next child (right)
		}

		return size + 1;
	}

	/**
	 * Height of tree
	 * 
	 * @return height | height of tree
	 */
	public int height() {

		if (this.getLeft() != null && this.getRight() != null) { // recursive call if both children are not null
			return 1 + Math.max(this.getLeft().height(), this.getRight().height());
		} else if (this.getLeft() == null && this.getRight() == null) { // return 1 if no children
			return 1;
		} else {
			if (this.getLeft() == null) { // recursive on right
				return 1 + this.getRight().height();
			} else if (this.getRight() == null) { // recursive on left
				return 1 + this.getLeft().height();
			} else {
				return 0;
			}
		}
	}

	/**
	 * Node level insert
	 * 
	 * @return bool | successful insert or not
	 */
	public boolean insert(T val) {

		if (this.getData().compareTo(val) == 0) { // return false if values are identical
			return false;
		} else if (this.getData().compareTo(val) > 0) { // move down left if less than
			if (this.getLeft() == null) {
				this.setLeft(new BinaryTreeNode<T>(val));
				return true;
			} else {
				return this.left.insert(val);
			}
		} else { // move down right if greater than
			if (this.getRight() == null) {
				this.setRight(new BinaryTreeNode<T>(val));
				return true;
			} else {
				return this.right.insert(val);
			}
		}
	}

	/**
	 * Create inOrder string
	 * 
	 * @return String output | inOrder traversal as string
	 */
	public String inOrder() {

		String output = "";

		if (this.getLeft() != null) { // move down left subtree
			output += this.getLeft().inOrder();
		}

		output += "(" + this.data + ")"; // add to string

		if (this.getRight() != null) {
			output += this.getRight().inOrder(); // mode down right subtree

		}

		return output;

	}

	/**
	 * Create postOrder string
	 * 
	 * @return String output | postOrder traversal as string
	 */
	public String postOrder() {

		String output = "";

		if (this.getLeft() != null) { // move down left subtree
			output += this.getLeft().postOrder();
		}

		if (this.getRight() != null) { // move down right subtree
			output += this.getRight().postOrder();

		}

		output += "(" + this.data + ")"; // add to string

		return output;
	}

	/**
	 * Main method
	 * 
	 * For main method testing, etc
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {

	}

}
