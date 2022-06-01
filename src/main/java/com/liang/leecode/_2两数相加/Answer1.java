package com.liang.leecode._2两数相加;

/*
给你两个非空 的链表，表示两个非负的整数。
它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Answer1 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        int[] input1 = {1, 2};
        int[] input2 = {1, 1};
        int l1Length = input1.length;
        int l2Length = input2.length;
        while (l1Length >0) {
            l1.val = input1[l1Length - 1];
            l1Length--;
            if(l1Length>0){
                l1 = new ListNode(0, l1);
            }
        }
        System.out.println();
        System.out.println("-----------");
        while (l2Length > 0) {
            l2.val = input2[l2Length - 1];
            l2Length--;
            if (l2Length > 0) {
                l2 = new ListNode(0, l2);
            }
        }

        testListNodeData(l1, l2);
        ListNode result = solution(l1,l2);
        while(result!=null){
            System.out.print(result.val);
            result = result.next;
        }
    }

    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode l3 ;
        ListNode temp = new ListNode();
        int rest = 0;   //进位的数字
        int sum = 0;    //两数之和
        int add = 0;    //最终获得两数之和需要保存的数（个位数）

        //如果l1或者l2不为空就进入循环
        while (l1 != null || l2 != null) {
            //如果l1不为空且l2也不为空
            if (l1 != null & l2 != null) {
                sum = l1.val + l2.val + rest;
            }
            //或者:如果l1不为空且l2为空
            else if (l1 != null & l2 == null) {
                sum = l1.val + rest;
            }
            //其他:l1为空且l2不为空
            else {
                sum = l2.val + rest;
            }

            add = sum % 10;
            rest = sum / 10;

           //这时处理数字和,给结果给l3的结点赋值


            l1 = l1.next;
            l2 = l2.next;

            //temp给新结点赋值，把之前的结点放入next结点

            if(null!=l1.next||null!=l2.next){
                temp = new ListNode(add,temp);
            }else{
                temp = new ListNode(add);
            }
            System.out.println();
        }

        l3 = temp;
        return l3;
    }

    //测试生成链表是否成功
    public static void testListNodeData(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        System.out.println();
        System.out.print("l1 = ");
        while (l1 != null) {
            System.out.print(l1.val);
            l1 = l1.next;
        }
        System.out.println();
        System.out.print("l2 = ");
        while (l2 != null) {
            System.out.print(l2.val);
            l2 = l2.next;
        }
    }

}
