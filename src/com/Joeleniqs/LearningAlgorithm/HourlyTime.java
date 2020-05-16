package com.Joeleniqs.LearningAlgorithm;

import java.util.HashSet;

public class HourlyTime {
        public int solution(String S, String T) {
            // write your code in Java SE 11
            String[] sArray = S.split(":");
            String[] tArray = T.split(":");

            char[] uniqueChars = sArray[0].toCharArray();
            //calculate hourly difference in Seconds
            int hd = (Integer.parseInt(tArray[0]) - Integer.parseInt(sArray[0]) )* 3600;
            //calculate minute difference in Seconds
            int md = (Integer.parseInt(tArray[1]) - Integer.parseInt(sArray[1])) * 60;
            //calculate seconds difference in Seconds
            int sd = Integer.parseInt(tArray[2]) - Integer.parseInt(sArray[2]);

            int total = hd + md + sd;
            int result = 0;
            for (int i = 1; i <= total; i++) {
                HashSet<Character> hs = new HashSet<>();

                int sec = i % 60;
                int min = i / 60;
                int hour = min / 60;

                String sSeconds = String.valueOf((Integer.parseInt(tArray[2]) + sec));
                sSeconds = sSeconds.length() < 2 ? "0" + sSeconds : sSeconds;
                String sMinutes = String.valueOf((Integer.parseInt(tArray[1]) + min));
                sMinutes = sMinutes.length() < 2 ? "0" + sMinutes : sMinutes;
                String sHours = String.valueOf((Integer.parseInt(tArray[0]) + hour));
                sHours = sHours.length() < 2 ? "0" + sHours : sHours;

                //System.out.println(sSeconds + " -  " + sMinutes + " -  " + sHours + " i = " + i);

                int k = 0;
                while (k < 2) {
                    hs.add(sSeconds.charAt(k));
                    hs.add(sMinutes.charAt(k));
                    hs.add(sHours.charAt(k));
                    k++;
                }
                if (hs.size() <= 2) result += 1;


            }
            System.out.println("REEEEEEEEE"+result);
            return result;

        }
    public int maxSubarraySumCircular(int[] A) {
        //check at 0,length
        //check at i,
        if(A == null|| A.length == 1) return A[0];

        int globalmax=Integer.MIN_VALUE;
        HashSet<Integer> hs = new HashSet<>();
        //check at each addition
        for(int i=0;i<A.length;i++){
            int localmax=0;
            if(A[i]>globalmax){
                globalmax = A[i];
            }
            if(A[i] < 0) hs.add(A[i]);
            for(int j=i+1;j<A.length;j++){
                if(i == A.length - 1) break;

                localmax += A[j];
                if(A[i] + localmax > globalmax){
                    globalmax = A[i] + localmax;
                }
            }

        }

        int circularMax = Integer.MIN_VALUE;
        for(int entry:hs){
            int localmax = 0;
            boolean done = false;
            int entryIndex = 0;
            for(int i=0;i<A.length;i++){
                if(A[i] != entry) {
                    localmax+=A[i];
                    if(localmax > circularMax) circularMax = localmax;
                }
                else if(A[i] == entry && !done) {
                    done = true;
                    entryIndex = i;
                }
                else if(A[i] == entry && done){
                    int diff = i - entryIndex;
                    int count=1;
                    while(count< diff){
                        localmax -= A[i-count] != entry ?A[i-count]:0;
                        count+=1;
                    }
                    if(localmax > circularMax) circularMax = localmax;

                }

            }
            if(localmax > circularMax) circularMax = localmax;
        }
        return globalmax = Math.max(globalmax,Math.max(A[0] + A[A.length-1],circularMax));
    }
    public int Kadanes(int[] array){
        int n = array.length;
        int[] dp = new int[n];

        //base condition
        dp[0] = array[0];

        int answer = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i - 1], 0) + array[i];
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}

