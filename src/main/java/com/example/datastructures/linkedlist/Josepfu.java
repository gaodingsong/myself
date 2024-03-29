package com.example.datastructures.linkedlist;

import org.springframework.jdbc.datasource.DataSourceUtils;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/7/4 16:02
 * @version:1.0
 */
public class Josepfu {
    public static void main(String[] args) {
        // 测试环形链表 和遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);// 添加五个小孩节点
        circleSingleLinkedList.showBoy();;

        // 测试小孩出圈
        circleSingleLinkedList.countBoy(1,2,5);

    }

}

// 创建一个环形的单向链表
class CircleSingleLinkedList{
    // 创建一个first接地那，当前节点没有编号
    private Boy first  = null;
    // 添加小孩节点，构建一个环形的链表
    public void addBoy(int nums){
        // nums做一个数据校验
        if (nums < 1){
            System.out.println("nums的值不正确");
            return;
        }

        Boy curBoy = null;// 复制指针，帮助我们构建环形链表
        // 适用for来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号，床架小孩节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i==1){
                first = boy;
                first.setNext(first);// 构成环
                curBoy =first;// 让curBoy指向第一个小孩
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }

        }


    }


    // 遍历当前环形链表
    public void showBoy(){
        // 判断链表是否为空
        if (first == null){
            System.out.println("没有任何小孩");

        }

        // 因为first不能动，因此我们仍然使用一个辅助指针来完成
        Boy curBoy= first;
        while (true){
            System.out.println("小孩的编号是："+curBoy.getNo());
            if (curBoy.getNext() == first){
                // 说明遍历完毕
                break;
            }
            curBoy = curBoy.getNext();// curBoiy后移
        }

    }



    // 根据用户的输入，计算出小孩出圈的顺序

    /**
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        // 先对数据进行校验
        if (first == null || startNo <1 || startNo >nums){
            System.out.println("参数有误");
            return;
        }
        // 创建要给辅助指针，帮助完成小孩出圈
        Boy helper = first;
        // 需求 创建一个辅助指针变量，helper  实现应该指向环形链表的最后这个节点
        while (true){
            if (helper.getNext() ==first){
                // 说明指向了最后的小孩节点
                break;
            }
            helper = helper.getNext();
        }
        // 小孩报数前  先放first和helper移动startNo-1次
        for (int i = 0; i < startNo-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当小孩报数时，让first和helper指针同时移动m-1次  然后出圈
        // 这里是一个循环操作，直到圈中只有一个节点
        while (true){
            if (helper == first){
                // 说明圈中只有一个节点
                break;
            }
            // 让first和helper指针同时移动countNum-1  然后出圈
            for (int i = 0; i < countNum-1; i++) {
                // 这时first指向的节点就是小孩要出圈的节点
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这时first指向的节点就是小孩要出圈的节点
            System.out.printf("小孩%d出圈 \n",first.getNo());
            // 这时将first指向的小孩出圈
            first = first.getNext();
            helper.setNext(first);
        }

        System.out.printf("最后留在圈中小孩编号%d \n",first.getNo());

    }
}

class Boy{
    private int no;// 编号
    private Boy next;// 指向下一个节点，默认null
    public Boy (int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
