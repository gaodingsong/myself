package com.example.datastructures.huffmantree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @PROJECT_NAME: myself
 * @DESCRIPTION:  赫夫曼树==》 数组变成赫夫曼树
 * @USER: gaodingsong
 * @DATE: 2021/8/27 16:01
 */
public class HuffmanTree {
    public static void main(String[] args) {

        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        createHuffmanTree(arr);
    }


    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("空數，不能遍歷");
        }

    }

    // 创建赫夫曼树
    public static Node createHuffmanTree(int[] arr){
        // 1,遍历数组
        // 2,将arr中的每个元素遍历成一个node
        // 3,将node存入到集合中
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1){

            Collections.sort(nodes);
            // 取出根节点权值最小的两颗二叉树
            // 1,取出最小的
            Node leftNode= nodes.get(0);

            // 2,取出次小的
            Node rightNode= nodes.get(1);
            // 3,構建一個新的二叉樹
            Node parent = new Node(leftNode.value+ rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            // 4,從集合中刪除已經處理的node
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            // 5，將parent加入到新的nodes
            nodes.add(parent);

            Collections.sort(nodes);
            System.out.println("第一次處理後的"+ nodes);
        }

        return nodes.get(0);
    }
}

// 创建节点类
//为了让node对象持续排序Collections集合排序，
//所以让node实现comparable接口
//
class Node implements Comparable<Node>{
    int value;// 节点权值
    Node left;// 左子节点
    Node right;// 右子节点

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    public void preOrder(){
        System.out.println(this);
        if (this.left!= null){
            this.left.preOrder();
        }
        if (this.right!= null){
            this.right.preOrder();
        }
    }


    public Node(int value){
        this.value = value;
    }


    @Override
    public int compareTo(Node o) {
        // 表示从小到大排序
        return this.value - o.value;
    }
}