package com.liang.leecode._2两数相加;

public class Answer2 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 2, 3};
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();

        l1 = fillListNode(l1, a);
        l2 = fillListNode(l2, b);
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
        System.out.println();
        while (l2 != null) {
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }



    public ListNode testAddTwoNumbers(ListNode l1,ListNode l2){
        ListNode l3 = new ListNode();
        int add = 0;
        int r = 0;
        int sum = 0;
        //当l1或者l2其中一个不为null就进入循环
        while(l1!=null||l2!=null){


            sum =  l1.val + l2.val + r; //第一个加+第二个+进位数字 = 本次相加的结果sum


            r = (sum>10 ? sum%10 : 0); //sum大于10，就对10求整，否则进位为0



        }



        return l3;
    }







    //填充构建ListNode
    private static ListNode fillListNode(ListNode l1, int[] a) {
        int l = a.length;
        if (l > 0) {
            l1 = new ListNode(a[l - 1]);
            l = l - 1;
        }

        while (l > 0) {
            l--;
            l1 = new ListNode(a[l], l1);
        }

        return l1;
    }

}
