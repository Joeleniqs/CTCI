package com.Joeleniqs.LearningAlgorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class NumberCompliment {

    public int findComplement(int num) {
        int cp = num;
        int sum = 0;
        while(num > 0){
            sum = (sum << 1) + 1;
            num >>= 1;
        }
        return sum - cp;
    }
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        for(int num : nums) hm.add(num);
        return hm.size();
    }
}
