package com.Joeleniqs.LearningAlgorithm;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class BinarySearchTree {
    BinarySearchNode root;

    public void put(String key, Object value) {
        if (root == null) {
            root = new BinarySearchNode(key, value);
        } else {
            root.put(key, value);
        }
    }

    public Object get(String key) {
        return (root != null) ? root.find(key) : -1;
    }
    public void printTreeInOrder(){
        root.printInOrder();
    }
    public void printTreePreOrder(){
        root.printPreOrder();
    }
}

class BinarySearchNode {
    private String key;
    private Object value;
    private BinarySearchNode left, right;

    BinarySearchNode() {

    }

    BinarySearchNode(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public void put(@NotNull String key, Object value) {
        if (key.compareTo(this.key) < 0) {
            //put in left
            if (left != null) left.put(key, value);
            else left = new BinarySearchNode(key, value);
        } else if (key.compareTo(this.key) > 0) {
            //put in right
            if (right != null) right.put(key, value);
            else right = new BinarySearchNode(key, value);
        } else {
            //update node value
            this.value = value;
        }
    }

    public Object find(String key) {
        if (key.compareTo(this.key) < 0) {
            return left == null ? null : left.find(key);
        } else if (key.compareTo(this.key) > 0) {
            return right == null ? null : right.find(key);
        }
        return this.value;
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(key);
        if (right != null) {
            right.printInOrder();
        }

    }
    public void printPreOrder(){
        System.out.print(key);
        if(left != null){
            left.printPreOrder();
        }
        if(right != null){
            right.printPreOrder();
        }
    }
}