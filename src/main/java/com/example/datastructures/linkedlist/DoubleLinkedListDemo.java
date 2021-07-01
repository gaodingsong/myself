package com.example.datastructures.linkedlist;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/7/1 10:14
 * @version:1.0
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("双向链表测试~~~~~");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();

        HeroNode2 hero5 = new HeroNode2(4, "公孙胜", "入云龙");

        doubleLinkedList.update(hero5);
        doubleLinkedList.list();


        System.out.println("shanchu ");
        doubleLinkedList.del(3);
        doubleLinkedList.list();
    }
}


class DoubleLinkedList{

    private HeroNode2 head = new HeroNode2(0,"","");
    // 返回头节点
    public HeroNode2 getHead(){
        return head;
    }




    //显示链表【遍历】
    public void list(){
        // 判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
        }
        // 因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true){
            // 判断是否到链表最后
            if (temp == null){
                break;
            }
            // 输出节点信息
            System.out.println(temp);
            // 将temp后移
            temp = temp.next;
        }
    }



    //添加节点到双向链表
    public void add(HeroNode2 headNode){
        // 因为head节点不能动，因此我们需要一个辅助遍历，temp
        HeroNode2 temp = head;
        // 遍历链表，找到最后
        while (true){
            // 找到链表的最后
            if (temp.next == null){
                break;
            }
            // 如果没有找到最后，将temp后移
            temp = temp.next;
        }
        // 当退出while循环的时候，temp就指向了链表的最后
        //将最后的这个节点的next指向新的节点
        // 形成一个双向链表
        temp.next = headNode;
        headNode.pre = temp;
    }



    public void update(HeroNode2 newHeroNode){
        // 判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点  根据no编号
        // 定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;// 表示是否找到该节点
        while (true){
            if (temp == null){
                break;// 已经遍历完链表
            }
            if (temp.no == newHeroNode.no){
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag 判断是否找到要修改的节点
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.printf("没有找到编号 %d的节点，不能修改\n",newHeroNode.no);
        }


    }




    // 从双向链表中删除一个节点
    // 1.对于双向链表，我们可以直接找到这个要删除的节点
    // 2.找到后  自我删除即可
    public void del(int no){

        //判断当前节点是否为空
        if (head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;// 标志是否找到待删除节点
        while (true){
            if (temp == null){
                // 已经到链表的最后
                break;
            }
            if (temp.no  == no){
                // 找到了待删除节点的no
                flag = true;
                break;
            }
            temp = temp.next;// 后移

        }
        if (flag){
            // 找到
            // 可以删除
//            temp.next = temp.next.next;
            temp.pre.next = temp.next;
            // 这里我们的代码有问题?
            if(temp.next != null){

                temp.next.pre = temp.pre;
            }


        }else {
            System.out.printf("要删除的%d节点不存在\n",no);
        }


    }

}



//  定义HeroNode  每个HeroNode对象就是一个节点
class HeroNode2 {

    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;// 指向下一个节点
    public HeroNode2 pre;// 指向上一个节点


    // 构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;

    }
    // 为了显示方法，重新tostring


    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +

                '}';
    }
}