package com.Joeleniqs.LearningAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        LinkedList<Character> mag = new LinkedList<>();
        int count = 0;
        var ranArray = ransomNote.toCharArray();
        var magArray = magazine.toCharArray();
        for(char c : magArray){
            mag.add(c);
        }
        for(int i =0 ;i<ranArray.length;i++){
            Character c = ranArray[i];
            if(mag.contains(c)) {
                mag.remove(c);
                count+=1;
            }
            else continue;
        }
        return ranArray.length != count ? false:true;
    }
}
