package com.blogspot.vikky.trees;

import java.util.Random;

import com.blogspot.vikky.trees.binarySearchTree.BinarySearchTree;

public class mainTest {

	public static void main(String[] args) {
		BSTRun();
	}

	public static void BSTRun() {
		BinarySearchTree<Integer> mTree = new BinarySearchTree<Integer>();
	
		generateRandomTree(mTree, 10);
		mTree.preOrderTraversal();
		mTree.inOrderTraversal();
		mTree.postOrderTraversal();
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
	
	public static void generateRandomTree(BinarySearchTree<Integer> mTree, int size) {
		mTree.clear();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(size);
		while(mTree.size() != randomInt) {
			int randomInt1 = randomGenerator.nextInt(size);
			if(!mTree.search(randomInt1))
				mTree.recursiveInsert(randomInt1);
		}
	}
}
