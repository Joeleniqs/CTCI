package com.Joeleniqs.LearningAlgorithm;

import java.util.PriorityQueue;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
public class addTwoNumbers {
    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        int num1 = getNodeValue(l1,new StringBuilder()), num2 = getNodeValue(l2,new StringBuilder()), result = num1 + num2;

        return parseNodeValue(result);
    }
    public int getNodeValue(ListNode l,StringBuilder res){
        res.insert(0,l.val);
        if(l.next != null) getNodeValue(l.next,res);
        return Integer.parseInt(res.toString());
    }
    public ListNode parseNodeValue(int result){
        ListNode res = new ListNode();
        while(result > 0){
            res = addToNode(res,result % 10);
            result /= 10;
        }
        System.out.println(getNodeValue(res , new StringBuilder()));
        return res;
    }
    public ListNode addToNode(ListNode node, int value){
        if(node.next != null) addToNode(node.next,value);
        else{
            node.val = value;
            node.next = new ListNode();
        }
        return node;
    }
}


   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


