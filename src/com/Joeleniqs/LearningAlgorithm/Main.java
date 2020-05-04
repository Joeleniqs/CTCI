package com.Joeleniqs.LearningAlgorithm;

import org.w3c.dom.Node;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // write your code here
       //PermutateString.permutate("joe");
        //new PQueue().example(new int[]{1,2,3,4,5 ,6 ,7,8,9,1,2,3,4});
        System.out.println(new RansomNote().canConstruct("aa","ab"));
        //var c = "abc".toCharArray();

        //FirstUnique use = new FirstUnique(new int[]{7,7,7,7,7,7});
//        System.out.println(use.showFirstUnique());
//        use.add(7);use.add(3);use.add(3);use.add(7);
//        use.add(17);
//        System.out.println(use.showFirstUnique());
//        BinarySearchTree Tree = new BinarySearchTree();
//        Tree.put("e",1);
//        Tree.put("a",2);Tree.put("b",3);Tree.put("x",4);Tree.put("f",5);
//        Tree.printTreePreOrder();
        //System.out.println(Tree.get("b"));
        //System.out.println(anagramProblem("hello","billion"));
    }

    //Ex -- 1
    //recursion matters for space complexity as well as time
    //time complexity 0(n) the same goes for space complexity
    public static int sum(int n) {
        if (n <= 0) return 0;

        return n + sum(n - 1);
    }

    //ex--2
    //time complexity 0(N) where space Complexity 0(1)
    public static int sumAdjacentNumbers(int n) {
        int sum = 0;
        StringBuilder adjacentList = new StringBuilder();
        if (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                int adjacentToAdd = (i + (i + 1));

                //if we only want between 0 and N
                if (adjacentToAdd > n) break;

                //add list to string builder
                adjacentList.append(adjacentToAdd);
                adjacentList.append(" ");

                //add values
                sum += (adjacentToAdd);
            }
        }
        System.out.println(adjacentList);
        return sum;
    }





}