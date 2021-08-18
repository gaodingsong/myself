package com.example.datastructures.tree.threadedbinarytree;

/**
 * 线索化二叉树
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {

        HeroNode root = new HeroNode(1,"tom");
        HeroNode node2 = new HeroNode(3,"jack");
        HeroNode node3 = new HeroNode(6,"smith");
        HeroNode node4 = new HeroNode(8,"mary");
        HeroNode node5 = new HeroNode(10,"king");
        HeroNode node6 = new HeroNode(14,"dim");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);


        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNode();
        HeroNode left = node5.getLeft();
        HeroNode right = node5.getRight();
        System.out.println("10号节点前驱节点是："+ left.toString());
        System.out.println("10号节点后继节点是："+ right.toString());
        System.out.println("=====================");
        threadedBinaryTree.threadedList();

    }
}


// 定义ThreadedBinaryTree二叉树，实现了线索化二叉树
class ThreadedBinaryTree{
    private HeroNode root;

    // 为了实现线索化 需要创建要给指向当前节点的前驱节点的指针
    // 在递归线索化的时候，pre总是保留前一个节点
    private HeroNode pre = null;



    public void threadedNode(){
        this.threadedNode(root);

    }

    public void threadedList(){
        HeroNode node = root;
        while (node != null){
            while (node.getLeftType() ==  0){
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }


    public HeroNode getPre() {
        return pre;
    }

    public void setPre(HeroNode pre) {
        this.pre = pre;
    }

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }



    // 编写对二叉树进行中序线索化的方法

    /**
     * node就是要线索化的节点
     * @param node
     */
    public void threadedNode(HeroNode node){
        // 如果node == null 不能线索化
        if (node == null){
            return;
        }

        // 三大步骤 1，因为是中序 左移先线索化左子树
        threadedNode(node.getLeft());
        // 三大步骤 2，线索化当前节点
        // 2.1 先处理当前节点的前驱节点
        if (node.getLeft()==null){
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点的左指针的类型
            node.setLeftType(1);
        }
        // 处理后继节点
        if (pre!= null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }

        // 每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        // 三大步骤 3，再线索化右子树
        threadedNode(node.getRight());

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

    // 如果 leftType == 0 表示指向左子树，leftType == 1 表示指向前驱节点

    private int leftType;
    // 如果 rightType == 0 表示指向又子树，rightType == 1 表示指向后继节点
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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