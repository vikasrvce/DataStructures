package com.blogspot.vikkyrk.ListAlgorithms;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class LLSort {
    List<Integer> ll = new LinkedList<Integer>();

    public void run() {
        generateRandomInput();
        printList();
        listSort1(ll);
        printList();
    }

    public void generateRandomInput() {
        Random rd = new Random();
        for (int i = 0; i < 10; i++) {
            ll.add(rd.nextInt(100));
        }
    }

    public void printList() {
        System.out.println("List Size " + ll.size());
        Iterator<Integer> iter = ll.iterator();
        System.out.println("");
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }

    public static <T extends Comparable<T>> void listSort1(List<T> ll) {
        for (int i = 0; i < ll.size(); i++) {
            Collections.swap(ll, i, findMin(ll, i));
        }
    }

    public static <T extends Comparable<T>> int findMin(List<T> ll, int from) {

        if (from < 0 || ll.size() == 0) {
            throw new RuntimeException("Invalid Index or List");
        }

        T temp, min = ll.get(from);

        if (from == ll.size() - 1)
            return from;

        ListIterator<T> iter = ll.listIterator(from + 1);
        while (iter.hasNext()) {
            temp = iter.next();
            if (temp.compareTo(min) < 0) {
                min = temp;
            }
        }
        return ll.indexOf(min);
    }
}
