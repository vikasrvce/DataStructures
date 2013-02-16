package com.blogspot.vikkyrk.List;

import java.util.Random;
import com.blogspot.vikkyrk.ListAlgorithms.*;

public class mainTest {

    public static void main(String[] args) {
        LLRun();
    }

    public static void LLRun() {
        LinkedListImpl<Integer> ml = new LinkedListImpl<Integer>();
        /*
         * ml.printList(); ml.add(2); ml.printList(); ml.add(4); ml.printList();
         * ml.add(1,ml.size()); ml.printList(); ml.add(4,0); ml.printList();
         * ml.set(5,0); ml.printList(); ml.set(3, 0); ml.printList();
         * ml.set(6,3); ml.printList(); System.out.println(ml.get(0));
         * System.out.println(ml.get(ml.size()-1));
         * 
         * Iterator<Integer> iter = ml.iterator();
         * 
         * while(iter.hasNext()) { System.out.println(iter.next()); }
         * 
         * ml.remove(0); ml.remove(0); ml.remove(0); ml.remove(0);
         * ml.printList();
         */

        generateRandomInput(ml);
        /*
         * ml.clear(); ml.add(1); ml.add(2); ml.add(3); ml.add(3); ml.add(2);
         * ml.add(1);
         */
        // ml.generateRandomLoop();
        // System.out.println("HasLoop = " + ml.hasLoop());
        // System.out.println("LoopStartIndex = " + ml.getLoopStartIndex());
        // System.out.println("Nth element From last =  " +
        // ml.getNthElementFromLast(5));
        ml.printList();
        // System.out.println("IsPalindrome = " + ml.isPalindrome());
        ml.reversePairwise();
        // ml.reverseList(4);
        ml.printList();
    }

    public static void generateRandomInput(LinkedListImpl<Integer> ml) {
        Random randomGen = new Random();
        int sz = randomGen.nextInt(12);
        for (int i = 0; i < sz; i++) {
            ml.add(randomGen.nextInt(100));
        }

    }
}
