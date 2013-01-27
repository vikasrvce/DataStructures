package com.blogspot.vikky.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.blogspot.vikky.trees.binarySearchTree.BinarySearchTree;
import com.blogspot.vikky.trees.binaryTree.BinaryTree;

public class mainTest {

	public static void main(String[] args) {
		//BSTRun();
		BTRun();
	}

	public static void BTRun() {
		Character[] cio = {'D','B', 'E', 'A', 'F', 'C'};
		Character[] cpo = {'A', 'B', 'D', 'E', 'C', 'F'};
		List<Character> preOrder = new LinkedList<Character>(Arrays.asList(cpo));
		List<Character> inOrder = new LinkedList<Character>(Arrays.asList(cio));
	
		System.out.println("List = " + preOrder.get(0));
		BinaryTree<Character> mCTree = new BinaryTree<Character>(preOrder, inOrder);
		
		mCTree.breadthFirstTraversal();
	/*	BinaryTree<Integer> mTree = new BinaryTree<Integer>();
		mTree.insert(1);
		mTree.insert(2);
		mTree.insert(3);
		mTree.insert(4);
		mTree.insert(5);
		mTree.insert(6);
		
		mTree.delete(1);
		mTree.delete(6);*/
		
		/*generateRandomBinaryTree(mTree,10);
		
		mTree.delete(1);
		mTree.delete(2);
		mTree.delete(3);
		mTree.delete(4);
		mTree.delete(5);
		mTree.delete(6);
		
		mTree.breadthFirstTraversal();
		
		mTree.insert(1);
		mTree.insert(2);
		mTree.insert(3);
		mTree.insert(4);
		mTree.insert(5);
		mTree.insert(6);
		
		mTree.breadthFirstTraversal();*/
		
	}
	public static void BSTRun() {
		BinarySearchTree<Integer> mTree = new BinarySearchTree<Integer>();
	
		generateRandomBinarySearchTree(mTree, 10);
		//mTree.preOrderTraversal();
		//mTree.inOrderTraversal();
		System.out.println("Tree Size = " + mTree.size());
		System.out.println("Height of Tree = " + mTree.maxHeight());
		//mTree.postOrderTraversal();
	    System.out.println("Diameter of Tree = " + mTree.diameter());
		mTree.breadthFirstTraversal();
		/*mTree.recursiveInsert(1);
		mTree.recursiveInsert(2);
		mTree.recursiveInsert(3);
		mTree.recursiveInsert(4);
		//mTree.recursiveInsert(5);
		//mTree.recursiveInsert(6);
		//mTree.recursiveInsert(7);
		mTree.balanceUsingRotation();
		System.out.println(mTree.isBalanced());*/
		
		/*Random randomGen = new Random();
		
		for(int i=1;i<10;i++) {
			
			generateRandomTree(mTree,i);
			System.out.println("\n\nTree Construction");
			if(!mTree.isBST())
				throw new RuntimeException("Failed for input Size" + i);
			else
				System.out.println("Success for Size = " + mTree.size());
	
			mTree.delete(randomGen.nextInt(i));
			mTree.delete(randomGen.nextInt(i));
			mTree.delete(randomGen.nextInt(i));
			mTree.delete(randomGen.nextInt(i));
			
			System.out.println("Deletion Test");
			if(!mTree.isBST())
				throw new RuntimeException("Failed for input Size" + i);
			else
				System.out.println("Success for Size = " + mTree.size());
			
			mTree.rotateRightAll();
			System.out.println("Right Rotation Test");
			if(!mTree.isBST()) {
				mTree.inOrderTraversal();
				mTree.breadthFirstTraversal();
				throw new RuntimeException("Failed for input Size" + i);
			}
			else
				System.out.println("Success for Size = " + mTree.size());
			
			mTree.rotateLeftAll();
			System.out.println("Left Rotation Test");
			if(!mTree.isBST()) {
				mTree.inOrderTraversal();
				mTree.breadthFirstTraversal();
				throw new RuntimeException("Failed for input Size" + i);
			}	
			else
				System.out.println("Success for Size = " + mTree.size());
			
			
			mTree.balanceWithExtraMemory();
			System.out.println("Balance using Memory Test: Height = " + mTree.maxHeight());
			if(!mTree.isBST() || !mTree.isBalanced())
			{
				mTree.inOrderTraversal();
				mTree.breadthFirstTraversal();
				throw new RuntimeException("Failed for input Size" + i);
			} else
				System.out.println("Success for Size = " + mTree.size());
			
			mTree.balanceUsingRotation();
			System.out.println("Balance using Rotation Test: Height = " + mTree.maxHeight());
			if(!mTree.isBST() || !mTree.isBalanced()) {
				mTree.inOrderTraversal();
				mTree.breadthFirstTraversal();
				throw new RuntimeException("Failed for input Size" + i);
			} else
				System.out.println("Success for Size = " + mTree.size());
			
			mTree.breadthFirstTraversal();
			mTree.clear(); 
		} */
	}
	
	/***************** Random Tree Input Generation and Testing ***************************/
	
	public static void generateRandomBinarySearchTree(BinarySearchTree<Integer> mTree, int size) {
		mTree.clear();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(size);
		while(mTree.size() != randomInt) {
			int randomInt1 = randomGenerator.nextInt(size);
			if(!mTree.search(randomInt1))
				mTree.recursiveInsert(randomInt1);
		}
	}
	
	public static void generateRandomBinaryTree(BinaryTree<Integer> mTree, int size) {
		mTree.clear();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(size);
		while(mTree.size() != randomInt) {
			int randomInt1 = randomGenerator.nextInt(size);
			if(!mTree.search(randomInt1))
				mTree.insert(randomInt1);
		}
	}
}
