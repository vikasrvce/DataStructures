package com.blogspot.vikkyrk.Stack;

import com.blogspot.vikkyrk.StackAlgorithms.StackAlgorithms;

public class mainTest {

	public static void main(String[] args) {
		stackRun();
		StackAlgorithms.StockSpan();
		StackAlgorithms.LRAHistogram();
	}

	public static void stackRun() {
		StackInterface<Integer> mStack = new ArrayStackImpl<Integer>(10);
		mStack.push(1);
		mStack.push(2);
		mStack.push(3);
		System.out.println(mStack.toString());
		mStack.pop();
		mStack.pop();
		System.out.println(mStack.toString());
		System.out.println(mStack.pop());
		System.out.println(mStack);
	}
}
