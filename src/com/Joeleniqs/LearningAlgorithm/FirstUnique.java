package com.Joeleniqs.LearningAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class FirstUnique {
    HashMap<Integer,Integer> hm = new HashMap<>();
    HashMap<Integer,Integer> values = new HashMap<>();
    HashMap<Integer,Integer> indexValues = new HashMap<>();
    int [] myNums;
    public FirstUnique(int[] nums) {
        myNums = nums;
        FirstUnique(nums,false ,0);
    }
public void FirstUnique(int [] nums,boolean add ,int addValue){
        if(add){
            if(values.containsKey(addValue)){
                var existingOneCount = hm.get(addValue);
                if(existingOneCount < 2) {
                    hm.put(addValue, existingOneCount+1);
                }
            }
            else {
                hm.put(addValue,1);
                values.put(addValue,(myNums.length) +1);
                indexValues.put(myNums.length+1,addValue);
            }
        }else {
            for (int i = 0; i < nums.length; i++) {
                ComputeHashMaps(nums, i);
            }
        }
}

    private void ComputeHashMaps(int[] nums, int i) {
        if(values.containsKey(nums[i])){
            var existingOneCount = hm.get(nums[i]);
            if(existingOneCount < 2)
                hm.put(nums[i],existingOneCount+1);
        }
        else {
            hm.put(nums[i],1);
            values.put(nums[i],i);
            indexValues.put(i,nums[i]);
        }
    }

    public int showFirstUnique() {
        for(var entry : hm.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }

    public void add(int value) {
        FirstUnique(myNums,true,value);
    }
}


//check node at 0;
//check (left & rigt)
 //left(only) increase i; left.check(left,right) of left
 //right(only) increase i; right.check(left,right)
 //left&right increase i ; left.check ; right.check