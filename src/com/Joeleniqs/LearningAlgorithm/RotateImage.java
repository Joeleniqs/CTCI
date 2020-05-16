package com.Joeleniqs.LearningAlgorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 1 && matrix[0].length == 1) return;
        int rows = matrix.length, cols = matrix[0].length;
        List<Deque<Integer>> ld = new ArrayList<Deque<Integer>>();
        for (int j = 0; j <= cols - 1; j++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = rows - 1; i >= 0; i--) {
                dq.add(matrix[i][j]);
            }
            ld.add(dq);
        }
        System.out.println(ld);
        for (int i = 0; i<= rows - 1; i++) {
            Object [] array = ld.get(i).toArray();
            for (int j = 0; j<=cols - 1; j++) {
                String val = array[j].toString();
                int value = Integer.parseInt(val);
               matrix[i][j] = value;
           }
        }
        System.out.println(matrix);
    }
}
