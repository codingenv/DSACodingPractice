package com.dsa.practice.tree;

public class Helper {


    public static TreeNode constructTree(int arr[]){
        return insertLevelOrder(arr, 0);
    }

    public static TreeNode insertLevelOrder(int arr[], int i){
        if(i >= arr.length ) {
            return null;
        }
        TreeNode root = new TreeNode(arr[i]);
        root.left = insertLevelOrder(arr,2*i + 1);
        root.right = insertLevelOrder(arr, 2*i + 2);
        return root;
    }
}
