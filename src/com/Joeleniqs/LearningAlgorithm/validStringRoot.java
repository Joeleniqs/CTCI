package com.Joeleniqs.LearningAlgorithm;

/**
 * Definition for a binary tree node.

 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class validStringRoot {
    public boolean isValidSequence(TreeNode root, int[] arr) {
            return soln( root, arr,0);
    }
    public boolean soln(TreeNode root,int [] array,int index){
        if(root == null) return false;

        if(root.val != array[index]) return false;

        if(index == array.length-1)
            return (root.left == null && root.right == null);

        return ((soln(root.left,array,index+1))|| soln(root.right,array,index+1));

    }
}
