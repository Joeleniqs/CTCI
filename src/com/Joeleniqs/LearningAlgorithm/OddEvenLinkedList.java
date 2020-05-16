package com.Joeleniqs.LearningAlgorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class OddEvenLinkedList {
    Deque<Integer> oddDq = new ArrayDeque<>();
    Deque<Integer> evenDq = new ArrayDeque<>();
    public ListNode oddEvenList(ListNode head) {
        ListNode result = new ListNode();
        if(head == null || head.next == null) return head;
        int count = 1;
        var Node = head;
        while(true){
            if((count & 1) > 0) oddDq.push(Node.val);
            else evenDq.push(Node.val);

            if(Node.next != null){
                Node = Node.next;
                count += 1;
            }else{
                break;
            }

        }
        System.out.println(oddDq);
        System.out.println(evenDq);
        result.val = oddDq.pollLast();
        parseResult(result);
        return result;
    }
    public void parseResult(ListNode result){
        if(oddDq.size()>0){
            result.next = new ListNode();
            result.next.val = oddDq.pollLast();
            parseResult(result.next);
        }
        else if(evenDq.size()>0){
            result.next = new ListNode();
            result.next.val = evenDq.pollLast();
            parseResult(result.next);
        }else {
            return;
        }
    }
}
