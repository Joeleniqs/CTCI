package com.Joeleniqs.LearningAlgorithm;

import com.sun.source.tree.TypeCastTree;

import java.lang.reflect.Type;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
       //PermutateString.permutate("joe");
        //new PQueue().example(new int[]{1,2,3,4,5 ,6 ,7,8,9,1,2,3,4});

        LinkedList<Character> ls = new LinkedList<>();
        TreeMap<Integer,Character> tm = new TreeMap<>((a,b)->a-b);
        HashSet<Integer> hs = new HashSet<>();
        Deque<Integer> dq = new ArrayDeque<>();
        Object c= 1;
        Stack<Integer> st = new Stack<>();

        //System.out.println(Integer.parseInt(c.toString()));
        //new RotateImage().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        //System.out.println(new HourlyTime().maxSubarraySumCircular(new int[]{8,-1,-3,8,-6,-9,2,4}));
        System.out.println(new OddEvenLinkedList().oddEvenList(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))))));
        //System.out.println(new floodFill().floodFill(new int[][]{{1,1,1}},0,1,2));
        //PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->b-a);
        //System.out.println(new addTwoNumbers().addTwoNumber(new ListNode(2,new ListNode(4,new ListNode(3))),new ListNode(5,new ListNode(6,new ListNode(4)))));
        //new SolutionBFS().isCousins(new Node(1, new Node(2,null,new Node(4)),new Node(3,null,new Node(5))),4,5);

        //System.out.println(new SolutionStraight().checkStraightLine(new int[][]{{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}}));

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
