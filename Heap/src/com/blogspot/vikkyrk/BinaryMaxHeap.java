package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.Collection;

public class BinaryMaxHeap<T extends Comparable<T>> implements HeapInterface<T> {

    ArrayList<T> nArr = null;
    int totalSize = 0;

    public BinaryMaxHeap(int n) {
        nArr = new ArrayList<T>(n);
        totalSize = n;
    }

    public BinaryMaxHeap() {
        nArr = new ArrayList<T>();
    }

    public BinaryMaxHeap(Collection<T> input) {
        nArr = new ArrayList<T>(input);
        buildMaxHeap();
    }

    @Override
    public int size() {
        return nArr.size();
    }

    @Override
    public boolean isEmpty() {
        if (nArr.size() == 0)
            return true;
        return false;
    }

    @Override
    public void insert(T t) {
        nArr.add(t);
        increaseKey(size() - 1);
    }

    @Override
    public void delete(T t) {

    }

    @Override
    public T getRoot() {
        if (isEmpty())
            return null;
        T temp = nArr.get(0);
        T temp1 = nArr.remove(size() - 1);
        if (!isEmpty()) {
            nArr.set(0, temp1);
            maxHeapify(0);
        }
        return temp;
    }

    @Override
    public T peekRoot() {
        if (isEmpty())
            return null;
        return nArr.get(0);
    }

    @Override
    public void increaseKey(int i) {
        if (i >= size())
            return;

        while (i != 0) {
            if (nArr.get(parent(i)).compareTo(nArr.get(i)) < 0) {
                T temp = nArr.get(parent(i));
                nArr.set(parent(i), nArr.get(i));
                nArr.set(i, temp);
                i = parent(i);
            } else
                break;
        }
    }

    private int parent(int i) {
        if (i >= size())
            throw new RuntimeException();
        return (int) (i / 2);
    }

    private int leftChild(int i) {
        return 2 * i;
    }

    private int rightChild(int i) {
        return 2 * i + 1;
    }

    private void maxHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < size()) {
            if (nArr.get(left).compareTo(nArr.get(i)) > 0)
                largest = left;
        }

        if (right < size()) {
            if (nArr.get(right).compareTo(nArr.get(i)) > 0)
                if (nArr.get(right).compareTo(nArr.get(left)) > 0)
                    largest = right;
        }

        if (largest != i) {
            T temp = nArr.get(i);
            nArr.set(i, nArr.get(largest));
            nArr.set(largest, temp);
            maxHeapify(largest);
        } else
            return;
    }

    private void buildMaxHeap() {
        for (int i = ((int) (size() / 2) - 1); i >= 0; i--) {
            maxHeapify(i);
        }
    }
}
