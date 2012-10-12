package com.blogspot.vikkyrk.StackAlgorithms;

import java.util.ArrayList;
import java.util.Random;

import com.blogspot.vikkyrk.Stack.ArrayStackImpl;

public class StackAlgorithms {
	
	/*
	 * In the stock span problem, we will solve a financial problem with the help of stacks.
	 * Suppose, for a stock, we have a series of n daily price quotes, the span of the stock's 
	 * price on a given day is defined as the maximum number of consecutive days just before 
	 * the given day, for which the price of the stock on the current day is less than or equal
	 * to its price on the given day.
	 * Let, Price(i) = price of the stock on day "i".
	 * Then, Span(i) = Max{k : k<=i and Price(j)<=Price(i) for j=i-k, .., i}
	 * Thus, if Price(i-1)>Price(i), then Span(i)=0.
	 */
	public static void StockSpan() {
		int size = 10;
		ArrayList<Integer> input = new ArrayList<Integer>(size);
		ArrayList<Integer> outputBruteForce = new ArrayList<Integer>(size);
		ArrayList<Integer> outputUsingStack = new ArrayList<Integer>(size);
		Random rG = new Random();
		
		for(int i=0; i<size; i++) {
			input.add(rG.nextInt(20));
			outputBruteForce.add(0);
			outputUsingStack.add(0);
		}
		
		System.out.println("input = " + input);
		
		for(int i=0; i<size; i++) {
			int j = i;
			while(j>=0 && input.get(j) <= input.get(i))
				j--;
			
			outputBruteForce.set(i, i-j-1);
		}
		
		System.out.println("outputBruteForce = " + outputBruteForce);
		
		ArrayStackImpl<Integer> stk = new ArrayStackImpl<Integer>(size);
		
		int h;
		
		for(int i=0; i<size; i++) {
			while(!stk.isEmpty()) {
				if(input.get(i) >= input.get(stk.peek()))
					stk.pop();
				else
					break;
			}
			
			if(stk.isEmpty())
				h = -1;
			else
				h = stk.peek();
			
			outputUsingStack.set(i, i-h-1);
			stk.push(i);
		}
		
		System.out.println("outputUsingStack = " + outputUsingStack);
	}
	
	/*
	 * Largest Rectangle under Histogram
	 */
	
	public static void LRAHistogram() {
		int size = 10;
		ArrayList<Integer> input = new ArrayList<Integer>(size);
		ArrayList<Integer> areas = new ArrayList<Integer>(size);
		Random rG = new Random();
		
		for(int i=0; i<size; i++) {
			input.add(rG.nextInt(20));
		    areas.add(0);
		}
		
		System.out.println("Input = " + input);
		
		int maxAreaBruteForce = 0;
		for(int i=0; i<size; i++) {
			int area = 0;
			for(int j=i; j>=0; j--) {
				if(input.get(j) >= input.get(i))
					area+=input.get(i);
				else
					break;
			}
			
			for(int j=i+1; j<size; j++) {
				if(input.get(j) >= input.get(i))
					area+=input.get(i);
				else
					break;
			}
			
			if(area > maxAreaBruteForce)
				maxAreaBruteForce = area;
		}
		
		System.out.println("MaxAreaBruteForce = " + maxAreaBruteForce);
		
		ArrayStackImpl<Integer> stk = new ArrayStackImpl<Integer>(size);
		int h;
		
		for(int i=0; i<size; i++) {
			while(!stk.isEmpty()) {
				if(input.get(stk.peek()) >= input.get(i))
					stk.pop();
				else
					break;
			}
			
			if(stk.isEmpty())
				h = -1;
			else
				h = stk.peek();
			
			areas.set(i, areas.get(i) + (input.get(i) * (i-h-1)));
			stk.push(i);
		}
		
		stk.clear();
		
		for(int i=size-1; i>=0; i--) {
			while(!stk.isEmpty()) {
				if(input.get(stk.peek()) >= input.get(i))
					stk.pop();
				else
					break;
			}
			
			if(stk.isEmpty())
				h = size;
			else
				h = stk.peek();
			
			areas.set(i, areas.get(i) + (input.get(i) * (h-i)));
			stk.push(i);
		}
		
		int maxAreaUsingStack = 0;
		
		for(int i=0; i<size; i++)
			if(areas.get(i) > maxAreaUsingStack)
				maxAreaUsingStack = areas.get(i);
		
		
		System.out.println("MaxAreaUsingStack = " + maxAreaUsingStack);
		System.out.println("Areas = " + areas);
	}
}
