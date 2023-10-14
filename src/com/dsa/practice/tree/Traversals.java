package com.dsa.practice.tree;

import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Traversals {

    public static void main(String args[]){
//        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int arr[] = {1,2,3,4,5,6,7};

        TreeNode root = Helper.constructTree(arr);

        Traversals obj = new Traversals();
        System.out.println("In Order");
        obj.inorderTraversal(root);
        System.out.println("\nPre Order");
        obj.preOrderTraversal(root);
        System.out.println("\nPost Order");
        obj.postOrderTraversal(root);
        System.out.println("\nLevel order");
        obj.levelOrderTraversal(root);
        System.out.println("\nLevel order traversal in groups");
        List<List<Integer>> result =  obj.levelOrderTraversal2(root);
        for(List<Integer> ol: result){
            for(Integer val: ol){
                System.out.print(val + " ");
            }
            System.out.print("      ");
        }

        System.out.println("\n postOrder using stack.");
        List<Integer> ol = obj.postOrderUsingTwoStack(root);
        for(Integer val: ol){
            System.out.print(val + " ");
        }


    }


    public void inorderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void postOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        if(root == null){
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            System.out.print(node.val + " ");
        }
        System.out.println();

    }

    public List<List<Integer>> levelOrderTraversal2(TreeNode root){
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        if(root == null){
            return null ;
        }
        List<List<Integer>> returnValue  = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int numberLevel = queue.size();
            List<Integer> subArray = new ArrayList<>();
            for(int i =0; i< numberLevel; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                subArray.add(node.val);
            }
            returnValue.add(subArray);
        }
        return returnValue;

    }

    public List<Integer> postOrderUsingTwoStack(TreeNode root){
        List<Integer> returnValue = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        if(root == null){
            return returnValue;
        }

        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left != null){
                st1.push(root.left);
            }
            if(root.right != null){
                st1.push(root.right);
            }
        }

        while(!st2.isEmpty()){
            returnValue.add(st2.pop().val);
        }

        return returnValue;


    }
}
