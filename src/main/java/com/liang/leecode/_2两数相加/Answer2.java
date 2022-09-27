package com.liang.leecode._2两数相加;

import org.junit.jupiter.api.Test;

public class Answer2 {


    @Test
    public void test() {

        int a[] = {1, 3, 4};
        int b[] = {1, 2};
        ListNode listNode1 = ListNodeGenerator.getListNode(a);
        System.out.println("  ---   ");
        ListNode listNode2 = ListNodeGenerator.getListNode(b);

        ListNode listNode = resolveIt(listNode1, listNode2);

        System.out.println(" 結果 ：");
        while (listNode != null) {
            System.out.println(listNode.val);

            if (listNode.next != null) {
                listNode = listNode.next;
            } else {
                break;
            }

        }
    }

    private ListNode resolveIt(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        int sum = 0;
        int over = 0;
        int add = 0;
        while (l1 != null || l2 != null) {

            boolean l1Null = (l1 == null);
            boolean l2Null = (l2 == null);

            if (l1Null) {
                // l2.next 不为null
                sum = l2.val + over;
                over = sum / 10;
                add = sum % 10;
                l2 = l2.next;
                l3.val = add;
            } else if (l2Null) {
                // l1.next 不为null
                sum = l1.val + over;
                over = sum / 10;
                add = sum % 10;
                l1 = l1.next;
                l3.val = add;
            } else {
                // l1、l2 next都不为null
                sum = l1.val + l2.val + over;
                over = sum / 10;
                add = sum % 10;

                l1 = l1.next;
                l2 = l2.next;
                l3.val = add;
            }

            if (l1 == null && l2 == null) {
                break;
            } else {
                l3 = new ListNode(0, l3);
            }

        }

        ListNode r = null;
        while (l3 != null) {
            if (r == null) {
                r = new ListNode(l3.val);
            } else {
                r = new ListNode(l3.val, r);
            }
            if (l3.next != null) {
                l3 = l3.next;
            } else {
                break;
            }
        }

        return r;
    }


}
