package com.blogspot.vikky.trees.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T extends Comparable<? super T>> {

    public BinaryTree() {

    }

    public BinaryTree(List<T> preOrder, List<T> inOrder) {
        constructTreePreIn(preOrder, inOrder);
    }

    private BinaryTree(BTNode<T> node) {
        root = node;
    }
    
    BTNode<T> root = null;

    private static class BTNode<K extends Comparable<? super K>> {
        K value;
        BTNode<K> left, right, parent;

        private BTNode(K t, BTNode<K> parent) {
            this(t, null, null, parent);
        }

        private BTNode(K t, BTNode<K> l, BTNode<K> r, BTNode<K> parent) {
            value = t;
            left = l;
            right = r;
            this.parent = parent;
        }

        @Override
        public String toString() {
            String s = "";
            s = s + value;
            return s;
        }
    }

    /*
     * ***************************** Size/maxHeight
     * ************************************
     */

    public int size() {
        return computeSize(root);
    }

    private int computeSize(BTNode<T> node) {
        if (node == null)
            return 0;
        return (1 + computeSize(node.right) + computeSize(node.left));
    }

    public int maxHeight() {
        return maxHeightIterative(root);
    }

    @SuppressWarnings("unused")
    private int maxHeight(BTNode<T> node) {
        if (node == null)
            return 0;
        int r = maxHeight(node.right);
        int l = maxHeight(node.left);
        return r > l ? r + 1 : l + 1;
    }

    /*
     * This uses BFS, explore using any of the DFS algorithms to get the max
     * height
     */
    private int maxHeightIterative(BTNode<T> node) {
        if (node == null)
            return 0;

        Queue<BTNode<T>> mQueue = new LinkedList<BTNode<T>>();
        mQueue.offer(node);
        mQueue.offer(null);
        BTNode<T> temp = null;
        int height = 0;
        while (!mQueue.isEmpty()) {
            temp = mQueue.remove();

            if (temp == null) {
                if (!mQueue.isEmpty())
                    mQueue.offer(null);
                height++;
            } else {
                if (temp.left != null)
                    mQueue.offer(temp.left);

                if (temp.right != null)
                    mQueue.offer(temp.right);
            }
        }
        return height;
    }

    /*
     * Few other properties can be calculated using iterative BFS 1. Find the
     * deepest node in a tree : the last node processed in BFS is the deepest 2.
     * Count the number of leaves/ print leaves: in BFS if (temp.right &&
     * temp.left == null) 3. Similarly for finding full nodes, half nodes. 4.
     * Check if 2 trees are structurally similar : use either pre-order or
     * post-order traversal
     */

    /*
     * ****************************** Insertion/Deletion
     * ***************************
     */

    public void clear() {
        clear(root);
    }

    private void clear(BTNode<T> node) {
        if (node == null)
            return;
        clear(node.left);
        clear(node.right);
        node = null;
    }

    public void insert(T t) {
        insertIterative(t);
    }

    /*
     * Duplicates are ignored
     */
    private void insertIterative(T t) {
        if (root == null) {
            root = new BTNode<T>(t, null);
            return;
        }
        Queue<BTNode<T>> mQueue = new LinkedList<BTNode<T>>();
        BTNode<T> temp = root;
        mQueue.offer(temp);

        while (!mQueue.isEmpty()) {
            temp = mQueue.remove();

            if (temp.value.compareTo(t) == 0)
                break;

            if (temp.left != null)
                mQueue.offer(temp.left);
            else {
                temp.left = new BTNode<T>(t, null, null, temp);
                break;
            }

            if (temp.right != null)
                mQueue.offer(temp.right);
            else {
                temp.right = new BTNode<T>(t, null, null, temp);
                break;
            }
        }

        mQueue.clear();
    }

    public void delete(T t) {
        delete(root, t);
    }

    private void delete(BTNode<T> head, T t) {
        BTNode<T> current = search(head, t);
        if (current == null)
            return;

        BTNode<T> parent = current.parent;
        BTNode<T> tempNode = null;

        if (current.left == null)
            tempNode = current.right;
        else if (current.right == null)
            tempNode = current.left;
        else {
            BTNode<T> tnode = getLeaf(current);
            if (tnode == null)
                throw new RuntimeException("Something went wrong");
            delete(tnode.value);
            tnode.left = current.left;
            tnode.right = current.right;
            if (tnode.left != null)
                tnode.left.parent = tnode;
            if (tnode.right != null)
                tnode.right.parent = tnode;
            tempNode = tnode;
        }

        if (current == root) {
            root = tempNode;
        } else if (current == parent.right) {
            parent.right = tempNode;
        } else {
            parent.left = tempNode;
        }

        if (tempNode != null)
            tempNode.parent = parent;
        current = null;
    }

    private BTNode<T> getLeaf(BTNode<T> node) {
        if (node == null)
            return null;

        if (node.left == null && node.right == null)
            return node;

        BTNode<T> temp = null;

        if (node.left != null)
            temp = getLeaf(node.left);

        if (temp != null)
            return temp;

        if (node.right != null)
            temp = getLeaf(node.right);

        if (temp != null)
            return temp;
        else
            return null;
    }

    /*
     * ********************** Search *************************
     */

    public boolean search(T t) {
        BTNode<T> node = null;
        node = search(root, t);

        if (node == null)
            return false;
        else
            return true;
    }

    private BTNode<T> search(BTNode<T> node, T t) {
        if (node == null)
            return null;

        if (node.value.compareTo(t) == 0)
            return node;

        BTNode<T> temp1 = search(node.left, t);

        if (temp1 != null)
            return temp1;

        temp1 = search(node.right, t);

        if (temp1 != null)
            return temp1;
        else
            return null;
    }

    /*
     * *******************************Traversals
     * ************************************
     */
    public void breadthFirstTraversal() {
        System.out.println("\nBreadthFirstTraversal");
        Queue<BTNode<T>> mQueue = new LinkedList<BTNode<T>>();
        mQueue.offer(root);
        breadthFirstTraversal(mQueue);
    }

    private void breadthFirstTraversal(Queue<BTNode<T>> mQueue) {
        BTNode<T> node = mQueue.poll();
        if (node == null)
            return;
        if (node.parent != null)
            System.out
                    .print("(" + node.value + "," + node.parent.value + "), ");
        else
            System.out.print("(" + node.value + "," + "null" + "), ");

        if (node.left != null)
            mQueue.offer(node.left);

        if (node.right != null)
            mQueue.offer(node.right);

        breadthFirstTraversal(mQueue);
    }

    private void constructTreePreIn(List<T> preOrder, List<T> inOrder) {
        int i = 0, j = 0;
        Stack<BTNode<T>> stk = new Stack<BTNode<T>>();
        BTNode<T> temp = null, prev = null;
        boolean right = false;

        while (i < preOrder.size()) {
            temp = new BTNode<T>(preOrder.get(i), null);
            stk.push(temp);

            if (i == 0)
                root = temp;
            else if (!right) {
                if (prev == null)
                    throw new RuntimeException("Invalid Input");
                prev.left = temp;
            } else {
                if (prev == null)
                    throw new RuntimeException("Invalid Input");
                prev.right = temp;
            }
            prev = temp;
            right = false;

            while ((!stk.isEmpty())
                    && (stk.peek().value.equals(inOrder.get(j)))) {
                prev = stk.pop();
                j++;
                right = true;
            }

            i++;
        }
    }
    
    public static <M extends Comparable<? super M>> BinaryTree<M> 
                  constructFromPreInOrder(ArrayList<M> preOrder, ArrayList<M> inOrder) {
        BTNode<M> root = constructFromPreInOrderInternal(preOrder, inOrder, 0, inOrder.size()-1);
        return new BinaryTree<M>(root);
    }
    
    /*
     * 1. Instead of Static use a mutable integer
     * 2. Complexity is O(n^2), mainly because of the search operation.
     * 3. Using a hash table would reduce the complexity to O(n).  
     */
    
    static int pSt = 0;
    private static <M extends Comparable<? super M>> BTNode<M> 
                  constructFromPreInOrderInternal(ArrayList<M> preOrder, ArrayList<M> inOrder,
                                                  int iSt, int iEnd) {
        if(iSt > iEnd)
            return null;
        
        BTNode<M> tNode = new BTNode<M>(preOrder.get(pSt++), null);
        
        int iIndex = inOrder.indexOf(tNode.value);
        
        tNode.left = constructFromPreInOrderInternal(preOrder, inOrder, iSt, iIndex-1);
        tNode.right = constructFromPreInOrderInternal(preOrder, inOrder, iIndex+1, iEnd);
        
        return tNode;
    }
    
}
