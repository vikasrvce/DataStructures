package com.blogspot.vikkyrk.Stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayStackImpl<T> implements StackInterface<T> {
ArrayList<T> stack = new ArrayList<T>();
	
	public ArrayStackImpl(int n) {
		stack.ensureCapacity(n);
	}
	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public void push(T t) {
		stack.add(t);
	}

	@Override
	public T pop() {
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return stack.remove(stack.size()-1);
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return stack.get(stack.size()-1);
	}

	@Override
	public void clear() {
		stack.clear();
	}

	public String toString() {
		return stack.toString();
	}
}
