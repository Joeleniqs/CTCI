package com.Joeleniqs.LearningAlgorithm;

import java.util.HashMap;

public class ValidJewel {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        //traverse through first array and add to hash map
        //check if jewel exists in hash Map
        var charArray = S.toCharArray();
        var jewelArray = J.toCharArray();
        for (char c : charArray) {
            if (hm.getOrDefault((int) c, -1) > 0) {
                hm.put((int) c, hm.get((int) c) + 1);
            } else hm.put((int) c, 1);
        }
        for (char jewel : jewelArray
        ) {
            if (hm.containsKey((int) jewel)) count += hm.get((int) jewel);
        }
        return count;
    }
}
