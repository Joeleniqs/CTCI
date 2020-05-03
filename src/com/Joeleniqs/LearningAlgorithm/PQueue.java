package com.Joeleniqs.LearningAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQueue implements Comparator{
    public class Node{

    }

   @Override
   public int compare(Object a, Object b){
       return (int)b-(int)a;
   }
    public void example(int [] entities){
        PriorityQueue<Integer> PrioritizedEntites = new PriorityQueue<>((a,b) -> a==b?a-b:b-a);
        int size = 0;
        for (var entity : entities){
            PrioritizedEntites.add(entity);
        }
        int once = 0;
        while (PrioritizedEntites.size()>0) {
            System.out.println(PrioritizedEntites.poll());
            System.out.println(PrioritizedEntites);
        }
    }


}
