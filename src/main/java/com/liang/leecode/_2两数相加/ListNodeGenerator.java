package com.liang.leecode._2两数相加;


/**
 * @author fl
 * @date 2022/6/1
 * @time 23:55
 * @desc
 **/
public final class ListNodeGenerator {


    /**
     * @param input 需要生成链表的数组
     * @return LisNode 返回的结果
     */
    public static ListNode getListNode(int[] input) {

        ListNode l1 = new ListNode();

        int length = input.length;
        // 循环链表赋值
        while (length > 0) {
            l1.val = input[length - 1];
            length--;
            if(length>0){
                l1 = new ListNode(0, l1);
            }
        }

//        // 打印测试链表
//        while (l1 != null) {
//            System.out.println(l1.val);
//
//            if (l1.next != null) {
//                l1 = l1.next;
//            }else {
//                break;
//            }
//        }
        return l1;
    }

    public ListNodeGenerator() {
    }
}
