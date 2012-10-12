package com.blogspot.vikkyrk;

public interface HeapInterface<T extends Comparable<T>> {
	int size();
	boolean isEmpty();
	void insert(T t);
	void delete(T t);
	T getRoot();
	T peekRoot();
	void increaseKey(int t);
}
