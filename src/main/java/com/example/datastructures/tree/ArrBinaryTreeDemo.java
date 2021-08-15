package com.example.datastructures.tree;

/**
 * 以数组的方式存储二叉树
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}
class ArrBinaryTree{
    private int[] arr;// 存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 重载preOrder
    public void preOrder(){
        this.preOrder(0);
    }

    // 编写一个方法，完成顺序存储二叉树的前序遍历

    /**
     *
     * @param index 数组的下标
     */
    public void preOrder(int index){
        if (arr == null || arr.length ==0){
            System.out.println("数组为空，不能按照二叉树前序遍历");
            return;
        }
        // 输出当前这个元素
        System.out.println(arr[index]);
        // 向左递归遍历
        if ((index*2+1) < arr.length){
            preOrder(index*2+1);
        }
        // 向右递归遍历
        if ((index*2+2) < arr.length){
            preOrder(index*2+2);
        }

    }
}