package com.Joeleniqs.LearningAlgorithm;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class PermutateString {

    public static void permutate(String word){
        permutate(word,"");
    }
    private static void permutate(String word,String prefix){
        LinkedList<Integer> rm = new LinkedList<Integer>();


        if (word.length() == 0) {
            System.out.println(prefix);
        }else {
        for (int i= 0; i < word.length(); i++) {
            String split1 = word.substring(0, i);
            String split2 = word.substring(i + 1);
            String rem =  split1 + split2 ;
            permutate(rem, prefix + word.charAt(i));
        }
        }
    }
}

