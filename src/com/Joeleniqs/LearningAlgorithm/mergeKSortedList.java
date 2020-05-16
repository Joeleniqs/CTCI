package com.Joeleniqs.LearningAlgorithm;

import java.util.PriorityQueue;

public class mergeKSortedList {

}
class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode();

        for(ListNode root : lists){
            addNodeToPQ(root);
        }

        return  addToResultNode(pq,res);

    }
    public void addNodeToPQ(ListNode node){
        if(node == null) return;

        pq.add(node.val);

        if(node.next != null) addNodeToPQ(node.next);

    }
    public ListNode addToResultNode(PriorityQueue<Integer> pq, ListNode result){
        if(result == null) return result;
        result.val = pq.poll();
        if(pq.size() > 1) {
            result.next = new ListNode();
            addToResultNode(pq,result.next);
        }

        return result;
    }
}

class SolutionStraight {
    double slope = Double.MIN_VALUE;
    public boolean checkStraightLine(int[][] coordinates) {
        int rows = coordinates.length;
        for(int i = 0;i<rows-1;i++){
            int cols = coordinates[i].length;
            for(int j=0;j< cols;j+=2){
                var x2x1 = (coordinates[i+1][j] - coordinates[i][j]);
                var y2y1 = (coordinates[i+1][j+1] - coordinates[i][j+1]) ;
                double lSlope =(double)y2y1/x2x1;
                if(slope==Double.MIN_VALUE) slope = lSlope;
                else{
                    if(lSlope != slope) return false;
                }
            }
        }
        return true;
    }
}
