package com.Joeleniqs.LearningAlgorithm;

import java.util.*;

public class BFS {
    public void printBFS(Node node){
        LinkedList<Node> ls = new LinkedList<>();
        ls.add(node);
        System.out.println(ls);
    }

    int xDepth=0,yDepth=0,xParent=0,yParent=0;
    boolean xFound,yFound;
    public boolean isCousins(Node root, int x, int y) {
        if(root == null || root.left == null && root.right ==null) return false;

        //traverseForX and Y
        traverse(root,x,y);
        System.out.println(xDepth +" "+yDepth +" "+xParent+" "+yParent+" ");
        if(xFound&&yFound){
            if(xParent == yParent) return true;
        }

        return false;
    }
    public void traverse(Node root, int x,int y){
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        while(!nodeStack.isEmpty()){
            var node = nodeStack.pop();

            if(node.val == x){
                xFound = true;
            }
            else if(node.val == y){
                yFound = true;
            }
            else{
                if(!xFound) {
                    xParent = node.val;
                }

                if( node.left != null || node.right!=null){
                    xDepth+=1;
                }
                if(node.left!=null)nodeStack.push(node.left);

                if(node.right!=null)nodeStack.push(node.right);

            }
            if(xFound && yFound) break;
        }
    }

}
class SolutionBFS {
    public boolean isCousins(Node root, int x, int y) {

        // Queue for BFS
        Queue<Node> queue = new LinkedList <> ();
        queue.add(root);

        while (!queue.isEmpty()) {
            boolean siblings = false;
            boolean cousins = false;

            int nodesAtDepth = queue.size();

            for (int i = 0; i < nodesAtDepth; i++) {
                // FIFO
                Node node = queue.remove();

                // Encountered the marker.
                // Siblings should be set to false as we are crossing the boundary.
                if (node == null) {
                    siblings = false;
                } else {
                    if (node.val == x || node.val == y) {
                        // Set both the siblings and cousins flag to true
                        // for a potential first sibling/cousin found.
                        if (!cousins) {
                            siblings = cousins = true;
                        } else {
                            // If the siblings flag is still true this means we are still
                            // within the siblings boundary and hence the nodes are not cousins.
                            return !siblings;
                        }
                    }

                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    // Adding the null marker for the siblings
                    queue.add(null);
                }
            }
            // After the end of a level if `cousins` is set to true
            // This means we found only one node at this level
            if (cousins) return false;
        }
        return false;
    }
}
class SolutionDFS {
    private int x;
    private int xParent;
    private int xDepth;
    private int y;
    private int yParent;
    private int yDepth;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || x == y || x == root.val || y == root.val) {
            return false;
        }
        this.x = x;
        this.y = y;
        traverseTree(root, null, 0);
        System.out.println(this.xDepth);
        System.out.println(this.yDepth);
        System.out.println(this.xParent);
        System.out.println(this.yParent);
        return this.xDepth == this.yDepth && this.xParent != this.yParent;
    }

    private void traverseTree(TreeNode root, TreeNode parent, int depth) {
        if (root == null) {
            return;
        }

        if (root.val == this.x) {
            this.xParent = parent.val;
            this.xDepth = depth;
        }

        if (root.val == this.y) {
            this.yParent = parent.val;
            this.yDepth = depth;
        }

        traverseTree(root.left, root, depth + 1);
        traverseTree(root.right, root, depth + 1);
    }

}
class Node{
    int val;
    Node left,right;
    public Node(int val) { this.val = val; }
    public Node(int val,Node left,Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SolutionJudge {
    public int findJudge(int N, int[][] trust) {
        //Hashset for trusted:if(size != 1)
        //Hashset for trustee:if(set contains Hashset value)
        HashSet<Integer> trusted = new HashSet<>();
        HashSet<Integer> trustee = new HashSet<>();
        int trialJudgeCount = 0,trialJudge=0;

        for(int i=0;i < trust.length;i++){
            trusted.add(trust[i][1]);
            trustee.add(trust[i][0]);
        }

        if(trustee.size() != N-1) return -1;

        for(var entry : trusted){
            if(!trustee.contains(entry)){
                trialJudge+=1;
                trialJudge=entry;
            }
        }
        if(trialJudgeCount==1) return trialJudge;

        return -1;

    }
}