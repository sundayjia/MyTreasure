package org.edie.alg.tree;

import java.util.NoSuchElementException;

/*
 * 构建二叉树;
 * 搜索二叉树；
 * 插入/删除节点
 */
public class BinaryTree {

	private Node root;

	private static class Node {
		Node left;
		Node right;
		Node parent;
		int data;

		Node(int data) {
			left = null;
			right = null;
			this.data = data;
		}
		
		Node(int data,Node left,Node right,Node parent){
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.data = data;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public void setData(int data) {
			this.data = data;
		}
		
		
	}

	public BinaryTree() {
		root = null;
	}

	/**
	 * 将数值输入构建二叉树
	 * 
	 * @param data
	 *            要输入的数值
	 */

	public void buildTree(int[] data) {
		for (int i = 0; i < data.length; i++) {
			insert(data[i]);
		}
	}

	/**
	 * 递归的插入数值
	 * 
	 * @param data
	 *            要插入的数值
	 */

	public void insert(int data) {
		root = insert(root, data);
	}

	/**
	 * 将数值插入到二叉树中，比当前结点小或等记混了于当前结点的插在当前结点的左侧，比当前结点大的数插在当前结点的右侧，每次从根结点开始递归比较
	 * 
	 * @param node
	 *            当前的结点，就是根结点，只是每次根结点的左右子孙更新
	 * @param data
	 *            要插入的数值
	 * @return 新排好的二叉树
	 */

	private Node insert(Node node, int data) {
		
		if (node == null) {
			node = new Node(data);
		} else {
			Node parent = node;
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return (node);
	}

	/**
	 * 递归打印出二叉树
	 */

	public void printTree() {
		printTree(root);
		System.out.println();

	}

	/**
	 * 从根结点开始遍历，从树的最高层叶子结点开始输出，从左至右
	 * 
	 * @param node
	 *            当前的结点
	 */

	private void printTree(Node node) {
		if (node == null)
			return;
		printTree(node.left);
		System.out.print(node.data + "  ");
		printTree(node.right);
	}

	/**
	 * search: 在二叉查找树中查询给定关键字
	 * 
	 * @param key
	 *            给定关键字  
	 * @return 匹配给定关键字的树结点
	 */
	public Node search(int data) {
		Node node = root;
		while (node != null && node.data != data) {
			if (data < node.data) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return node;
	}



	/*remove
     */
    public Node remove(int number, Node tree) {
    	Node delete = null;
        if (tree == null)
            throw new IndexOutOfBoundsException("tree size is 0");
        
        if (number < tree.data) {// go left
            tree.left = remove(number, tree.left);
        } else if (number > tree.data) { // go right
            tree.right = remove(number, tree.right);
        } else if (tree.left != null && tree.right != null) {// two children 
            //replace with the smallest in right tree
            delete = findMin(tree.right);
            tree.setData(delete.data);
            tree.setRight(remove(tree.data, tree.right));
            delete = null;
        } else {// one or zero child
            delete = tree;
            if (delete.left == null) {
                tree = tree.right;
            } else if (delete.right == null) {
                tree = tree.left;
            }
            delete = null;
        }
        return tree;
    }
 
 // min
    public Node findMin(Node tree) {
        if (tree == null)
            throw new NoSuchElementException("no such element in the binary search tree");
        
        if (tree.left == null)
            return tree;
        else
            return findMin(tree.left);
 
    }


	public static void main(String args[]) {
		BinaryTree biTree = new BinaryTree();
		int[] data = { 2, 8, 7, 4, 9, 3, 1, 6, 7, 5 };
		biTree.buildTree(data);
		biTree.printTree();
	}
}
