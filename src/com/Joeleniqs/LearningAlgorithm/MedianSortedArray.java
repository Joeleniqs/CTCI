package com.Joeleniqs.LearningAlgorithm;

import java.util.PriorityQueue;

public class MedianSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length,length2 = nums2.length,i=0 , sumOfLength=length1+length2;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        while(i< Math.max(length1,length2)){
            if(i< length1) pq.add(nums1[i]);
            if(i<length2) pq.add(nums2[i]);
            i++;
        }
        if(((sumOfLength) & 1)>0) {
            stripHeap(pq,sumOfLength,true);
        }
        else{
            stripHeap(pq,sumOfLength,false);

            double median1 = pq.poll();
            double median2 = pq.poll();
            return (median1+median2)/2;
        }
        return (double)pq.peek();
    }
    public void stripHeap(PriorityQueue<Integer> pq,int sumOfLength,boolean odd){
        var index = (sumOfLength)/2;
        int strip = 0;
        while(strip < (odd?index:index-1)) {
            pq.poll();
            strip++;
        }

    }
}
