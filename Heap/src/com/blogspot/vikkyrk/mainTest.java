package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.Arrays;

public class mainTest {

    public static void main(String[] args) {
        BinaryMaxHeap<Integer> bHeap = new BinaryMaxHeap<Integer>(
                Arrays.asList(7, 9));
        bHeap.insert(5);
        bHeap.insert(8);
        bHeap.insert(1);

        while (bHeap.peekRoot() != null)
            System.out.println(bHeap.getRoot());
    }

}
