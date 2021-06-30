package com.example.datastructures.linkedlist;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/6/29 14:56
 * @version:1.0
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        // 进行测试
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        // 添加按照编号
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        // 测试修改节点的数据
        HeroNode heroNode = new HeroNode(2, "小卢", "玉麒麟~~");

        singleLinkedList.update(heroNode);
        singleLinkedList.list();

        // 删除节点
        singleLinkedList.del(1);

        singleLinkedList.del(4);
        // 删除后的
        System.out.println("删除后的节点列表展示~~~~~~~~~~");
        singleLinkedList.list();

        //测试一下，求单链表的有效节点的个数
        System.out.println("有效的节点个数：" + getLength(singleLinkedList.getHead()));


        //测试  查找单链表中的倒数第k个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);

        System.out.println("倒数第一个" + res);


    }

    // 查找单链表中的倒数第k个节点


    public static HeroNode findLastIndexNode(HeroNode head,int index){

        //判断如果为null就返回null
        if (head.next == null){
            return null;
        }
        // 第一个遍历得到链表的长度（节点个数）
        int size = getLength(head);
        // 第二次遍历 size-index位置，就是我们倒数第k个节点
        // 先做一个index的校验
        if (index <= 0 || index >size){
            return null;
        }
        // 定义辅助变量你 for 循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size -index; i++) {
            cur = cur.next;

        }
        return cur;

    }


    // 获取单链表的有效节点的个数
    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        // 定义一个辅助变量,这里没有统计头节点
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;

    }



}

// 定义SingleLinkedList管理我们的英雄
class SingleLinkedList{
    // 先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    // 返回头节点
    public HeroNode getHead(){
        return head;
    }


    // 添加节点到单项链表
    // 思路：当不考虑编号的顺序时
    // 1.先张公案到当前链表的最后节点
    // 2.将最后的这个节点的next指向新的节点
    //
    public void add(HeroNode headNode){
        // 因为head节点不能动，因此我们需要一个辅助遍历，temp
        HeroNode temp = head;
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
        temp.next = headNode;
    }


    //第二种方式添加英雄时，根据排名将英雄添加到指定位置（如果存在排名，则添加失败，并给出提示）
    public void addByOrder(HeroNode headNode){
        // 因为头节点不能动，因此我们仍需要通过一个辅助指针来帮助找到添加的位置
        // 因为是单链表，所以我们找到temp位置是位于添加位置的前一个节点 否则插入不了
        HeroNode temp = head;
        boolean flag = false; // flag 标志添加的编号是否存在，默认为false
        while (true){
            if (temp.next == null){
                // 说明temp已在链表的最后
                break;
            }
            if (temp.next.no>headNode.no){
                // 位置找到，就在temp的后面插入
                break;
            }else if(temp.next.no == headNode.no){
                // 说明希望添加的heroNode编号依然存在
                flag = true;// 编号存在
                break;
            }
            temp = temp.next;// 后移，遍历当前链表
        }


        // 判断flag的值
        if (flag){
            // 编号存在，不能添加
            System.out.printf("准备插入的英雄编号%d 已经存在，不能添加\n",headNode.no);

        }else {
            // 插入到链表中，temp的后面
            headNode.next = temp.next;
            temp.next = headNode;
        }


    }



    // 修改节点的信息，根据no编号来修改，即no编号不能变
    // 1.根据newHeroNode的no来修改即可

    public void update(HeroNode newHeroNode){
        // 判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点  根据no编号
        // 定义一个辅助变量
        HeroNode temp = head.next;
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


    // 删除节点
    // 思路：
    // 1.head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    // 2.说明我们在比较时，是temp.next.no和西药删除接地那的no比较
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;// 标志是否找到待删除节点
        while (true){
            if (temp.next == null){
                // 已经到链表的最后
                break;
            }
            if (temp.next.no  == no){
                // 找到了待删除节点的no
                flag = true;
                break;
            }
            temp = temp.next;// 后移

        }
        if (flag){
            // 找到
            // 可以删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的%d节点不存在\n",no);
        }


    }


    //显示链表【遍历】
    public void list(){
        // 判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
        }
        // 因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
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

}

//  定义HeroNode  每个HeroNode对象就是一个节点
class HeroNode{

    public  int no;
    public String name;
    public String nickname;
    public HeroNode next;


    // 构造器
    public HeroNode(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname =nickname;

    }
    // 为了显示方法，重新tostring


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +

                '}';
    }
}
