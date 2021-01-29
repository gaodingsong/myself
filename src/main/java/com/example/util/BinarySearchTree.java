package com.example.util;

/**
 * @description:手写二叉排序树(BST)-Java实现
 * @author:dingsong.gao
 * @createTime:2021/1/27 14:43
 * @version:1.0
 */
public class BinarySearchTree {

    int data;
    BinarySearchTree left;
    BinarySearchTree right;

    public BinarySearchTree(int data) {
        this.data = data;
    }



    //插入节点
    public void insert(BinarySearchTree root,int data) {
        if(data>root.data) {
            if(root.right == null) {
                root.right = new BinarySearchTree(data);
            }else {
                insert(root.right, data);
            }
        }else {
            if(root.left == null) {
                root.left = new BinarySearchTree(data);
            }else {
                insert(root.left,data);
            }
        }
    }

    //中序遍历
    public void mid(BinarySearchTree root){
        if(root!=null) {
            mid(root.left);
            System.out.print(root.data+" ");
            mid(root.right);
        }
    }




    public static void main(String[] args) {
        int[] a = new int[] {5,9,0,1,2,3,10};
        BinarySearchTree root = new BinarySearchTree(a[0]);
        for(int i = 1;i<a.length;i++) {
            root.insert(root, a[i]);
        }

        System.out.println("中序遍历");//0 1 2 3 5 9 10   说明二叉搜索树的中序遍历是有序的
        root.mid(root);
    }




}
