package com.example.datastructures.hashtab;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {

        // 创建hashTab
        HashTab hashTab = new HashTab(7);
        // 编写一个简单的菜单
        String key ="";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("请输入id");
                    int id = scanner.nextInt();
                    System.out.println("请输入名称");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("請輸入id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}


class HashTab{
    private EmpLinkedList[] empLinkedListArray;

    private int size;// 表示共有多少条链表

    // 构造器
    public HashTab(int size){
        this.size = size;
        // 初始化empLinkedLists 大小
        empLinkedListArray = new EmpLinkedList[size];
        // 留一个坑   在这个地方不要忘了分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
            
        }
    }

    // 添加雇员
    public void add(Emp emp){

        // 根据员工的id  得到该员工应该加到哪个链表下面
        int empLinkedListNo= hashFun(emp.id);
        // 将emp加入到对应的链表中
        empLinkedListArray[empLinkedListNo] .add(emp);

    }
    // 编写散列函数    有很多种 1  取模法
    public int hashFun(int id){
        return id%size;
    }

    // 遍历所有的链表
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i+1);
            
        }
    }


    public void findEmpById(int id){

        int empLinkedListNo = hashFun(id);

        Emp empById = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (empById == null){
            System.out.println("鏈錶中沒有");

        }else {
            System.out.printf("在第%d 條鏈錶中找到僱員id = %id",(empLinkedListNo+1),id);
        }
    }

}
// 表示一个雇员
class Emp{

    public int id ;
    public String name;
    public Emp next; // 默认为null


    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}


class EmpLinkedList{
    // 头指针 指向第一个emp,
    private Emp head;// 默认null


    //添加雇员到  假定id自增，添加雇员 直接加入到链表最后

    public void add(Emp emp){
        // 如果是第一个雇员
        if (head == null){
            head = emp;
            return;
        }

        // 如果不是第一个员工，使用一个辅助指针，帮助定位到最后
        Emp curEmp = head;
        while (true){
            if (curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;

        }
        curEmp.next = emp;
    }

    // 遍历
    public void list(int no){

        if (head == null){
            System.out.println("第"+no+"链表为空");
            return;
        }
        System.out.print("当前第"+no+"链表的信息为：");
        Emp curEmp = head;
        while (true){
            System.out.printf("=>>id =%d ,name= %s",curEmp.id,curEmp.name);
            if (curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();

    }


    public Emp findEmpById(int id ){
        if (head == null){
            System.out.println("鏈錶為空");
            return null;
        }
        // 輔助指針
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }
            if (curEmp.next == null){
                // 說明沒有找到哦啊
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}