package com.example.datastructures.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"林冲");
        HeroNode node5 = new HeroNode(5,"关胜");

        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
//
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//
//        System.out.println("后序遍历");
//        binaryTree.postOrder();


//        System.out.println("前序遍历方式");
//        HeroNode resNode = binaryTree.preOrderSearch(5);
//        if (resNode != null){
//            System.out.println(resNode);
//        }else {
//            System.out.println("5号没有");
//        }
//        System.out.println("中序遍历方式");
//        HeroNode resNode = binaryTree.infixOrderSearch(5);
//        if (resNode != null){
//            System.out.println(resNode);
//        }else {
//            System.out.println("5号没有");
//        }


//        System.out.println("后序遍历方式");
//        HeroNode resNode = binaryTree.postOrderSearch(5);
//        if (resNode != null){
//            System.out.println(resNode);
//        }else {
//            System.out.println("5号没有");
//        }

        // 测试删除node
        System.out.println("前序遍历前");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("前序遍历后");
        binaryTree.preOrder();


    }
}

class BinaryTree{
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    public void delNode(int no){

        if (root != null){
            if (root.getNo() == no){
                root = null;
            }else {
                // 递归删除
                root.delNode(no);
            }
        }else {
            System.out.println("空数，不能删");
        }

    }

    public void preOrder(){
        if (this.root!= null){
            this.root.preOrder();
        }else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }


    public void infixOrder(){
        if (this.root!= null){
            this.root.infixOrder();
        }else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public void postOrder(){
        if (this.root!= null){
            this.root.postOrder();
        }else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    // 前序遍历
    public HeroNode preOrderSearch(int no){

        if (root != null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    public HeroNode infixOrderSearch(int no){

        if (root != null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    public HeroNode postOrderSearch(int no){

        if (root != null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }

}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left =null;
            return;

        }
        if (this.right != null && this.right.no == no){
            this.right =null;
            return;

        }

        //  向左递归
        if (this.left != null){
            this.left.delNode(no);
        }
        if (this.right != null){
            this.right.delNode(no);
        }
    }

    // 前序遍历
    public void preOrder(){
        System.out.println(this);
        // 向左遍历
        if (this.left!= null){
            this.left.preOrder();
        }
        // 向右遍历
        if (this.right!=null){
            this.right.preOrder();
        }


    }
    // 中序遍历

    public void infixOrder(){
        // 向左遍历
        if (this.left!= null){
            this.left.infixOrder();
        }

        System.out.println(this);
        // 向右遍历
        if (this.right!=null){
            this.right.infixOrder();
        }

    }

    // 后序遍历
    public void postOrder(){
        // 向左遍历
        if (this.left!= null){
            this.left.postOrder();
        }
        // 向右遍历
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }


    /**
     * 前序遍历
     * @param no
     * @return
     */
    public HeroNode preOrderSearch(int no){
        System.out.println("进入前序遍历");
        // 比较当前节点是不是
        if (this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;
    }

    /**
     * 中序遍历
     * @param no
     * @return
     */
    public HeroNode infixOrderSearch(int no){

        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        System.out.println("进入中序查找");
        if (this.no == no){
            return this;
        }

        if (this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }

        return resNode;
    }

    /**
     * 后续遍历
     * @param no
     * @return
     */
    public HeroNode postOrderSearch(int no){

        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }

        if (resNode != null){
            return resNode;
        }
        System.out.println("进入后序查找");
        if (this.no == no){
            return this;
        }
        return resNode;
    }


}
