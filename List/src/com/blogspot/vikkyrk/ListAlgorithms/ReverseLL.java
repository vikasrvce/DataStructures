package com.blogspot.vikkyrk.ListAlgorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ReverseLL {
    List<Integer> ll = new LinkedList<Integer>();

    public void run() {
        generateRandomInput();
        printList();
        reverseList1(ll);
        printList();
    }

    // O(n) - similar to Collections.reverseList()
    public static <T> void reverseList1(List<T> ll) {
        ListIterator<T> fIter = ll.listIterator();
        ListIterator<T> bIter = ll.listIterator(ll.size());

        for (int i = 0, mid = (ll.size() >> 1); i < mid; i++) {
            T temp = fIter.next();
            fIter.set(bIter.previous());
            bIter.set(temp);
        }
    }

    public void generateRandomInput() {
        Random rd = new Random();
        for (int i = 0; i < 11; i++) {
            ll.add(rd.nextInt(100));
        }
    }

    public void printList() {
        Iterator<Integer> iter = ll.iterator();
        System.out.println("");
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
