package com.blogspot.vikky.trees.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
	BTNode root = null;
	private class BTNode {
		T value;
		BTNode left, right, parent;
		
		private BTNode(T t, BTNode parent) {
			this(t,null,null,parent);
		}
		
		private BTNode(T t, BTNode l, BTNode r, BTNode parent) {
			value = t;
			left = l;
			right = r;
			this.parent = parent;
		}
		
		@Override
		public String toString() {
			String s = "";
			s = s + value;
			return s;
		}
	}
	
	/*
	 * ***************************** Size/maxHeight ************************************
	 */
	
	public int size() {
		return computeSize(root);
	}
	
	private int computeSize(BTNode node) {
		if(node == null) 
			return 0;
		return (1 + computeSize(node.right) + computeSize(node.left));
	}
	
	public int maxHeight() {
		return maxHeightIterative(root);
	}
	
	private int maxHeight(BTNode node) {
		if(node == null)
			return 0;
		int r = maxHeight(node.right);
		int l = maxHeight(node.left);
		return r>l?r+1:l+1;
	}

	/*
	 * This uses BFS, explore using any of the 
	 * DFS algorithms to get the max height
	 */
	private int maxHeightIterative(BTNode node) {
		if(node == null)
			return 0;
		
		Queue<BTNode> mQueue = new LinkedList<BTNode>();
		mQueue.offer(node);
		mQueue.offer(null);
		BTNode temp = null;
		int height = 0;
		while(!mQueue.isEmpty()) {
			temp = mQueue.remove();
			
			if(temp == null) {
				if(!mQueue.isEmpty())
					mQueue.offer(null);
				height++;
			} else {
				if(temp.left != null)
					mQueue.offer(temp.left);
				
				if(temp.right != null)
					mQueue.offer(temp.right);
			}
		}
		return height;
 	}
	
	
	/*
	 * Few other properties can be calculated using iterative BFS
	 * 1. Find the deepest node in a tree : the last node processed in BFS is the deepest
	 * 2. Count the number of leaves/ print leaves: in BFS if (temp.right && temp.left == null)
	 * 3. Similarly for finding full nodes, half nodes.
	 * 4. Check if 2 trees are structurally similar : use either pre-order or post-order traversal
	 */
	
	/*
	 * ****************************** Insertion/Deletion ***************************
	 */

	public void clear() {
		clear(root);
	}
	
	private void clear(BTNode node) {
		if(node == null)
			return;
		clear(node.left);
		clear(node.right);
		node = null;
	}
	
	public void insert(T t) {
		insertIterative(t);
	}
	
	/* 
	 * Duplicates are ignored
	 */
	private void insertIterative(T t) {
		if(root == null) {
			root = new BTNode(t,null);
			return;
		}
		Queue<BTNode> mQueue = new LinkedList<BTNode>();
		BTNode temp = root;
		mQueue.offer(temp);
		
		while(!mQueue.isEmpty()) {
			temp = mQueue.remove();
			
			if(temp.value.compareTo(t) == 0)
				break;
			
			if(temp.left != null) 
				mQueue.offer(temp.left);
			else {
				temp.left = new BTNode(t,null,null,temp);
				break;
			}
			
			if(temp.right != null)
				mQueue.offer(temp.right);
			else {
				temp.right = new BTNode(t,null,null,temp);
				break;
			}
		}
		
		mQueue.clear();
	}
	
	
	public void delete(T t) {
		delete(root,t);
	}
	
	private void delete(BTNode head, T t) {
		BTNode current = search(head,t);
		if(current == null)
			return;
		
		BTNode parent = current.parent;
		BTNode tempNode = null;
		
		if(current.left == null)
			tempNode = current.right;
		else if(current.right == null)
			tempNode = current.left;
		else {
			BTNode tnode = getLeaf(current);
			if(tnode == null)
				throw new RuntimeException("Something went wrong");
			delete(tnode.value);
			tnode.left = current.left;
			tnode.right = current.right;
			if(tnode.left != null)
				tnode.left.parent = tnode;
			if(tnode.right != null)
				tnode.right.parent = tnode;
			tempNode = tnode;
		}
			
		if(current == root) {
			root = tempNode;
		} else if(current == parent.right) {
			parent.right = tempNode;
		} else {
			parent.left = tempNode;
		}
		
		if(tempNode != null)
			tempNode.parent = parent;
		current = null;
	}
	
	private BTNode getLeaf(BTNode node) {
		if(node == null)
			return null;
		
		if(node.left == null && node.right == null)
			return node;
		
		BTNode temp = null;
		
		if(node.left != null)
			temp = getLeaf(node.left);
		
		if(temp != null)
			return temp;
	
		if(node.right != null)
			temp = getLeaf(node.right);
			
		if(temp != null)
			return temp;
		else
			return null;
	}
	
	/*
	 * ********************** Search *************************
	 */
	
	public boolean search(T t) {
		BTNode node = null;
		node = search(root,t);
		
		if(node == null)
			return false;
		else
			return true;
	}
	
	private BTNode search(BTNode node, T t) {
		if(node == null)
			return null;
		
		if(node.value.compareTo(t) == 0)
			return node;
		
		BTNode temp1 = search(node.left,t);
		
		if(temp1 != null)
			return temp1;
		
		temp1 = search(node.right,t);
		
		if(temp1 != null)
			return temp1;
		else 
			return null;
	}
	
	/*
	 * *******************************Traversals ************************************
	 */
	public void breadthFirstTraversal() {
		System.out.println("\nBreadthFirstTraversal");
		Queue<BTNode> mQueue = new LinkedList<BTNode>();
		mQueue.offer(root);
		breadthFirstTraversal(mQueue);
	}
	
	private void breadthFirstTraversal(Queue<BTNode> mQueue) {
		BTNode node = mQueue.poll();
		if(node == null) 
			return;
		if(node.parent != null)
			System.out.print("(" + node.value + "," + node.parent.value + "), ");
		else
			System.out.print("(" + node.value + "," + "null" + "), ");

		if(node.left != null)
			mQueue.offer(node.left);
		
		if(node.right != null)
			mQueue.offer(node.right);
		
		breadthFirstTraversal(mQueue);
	}
}
