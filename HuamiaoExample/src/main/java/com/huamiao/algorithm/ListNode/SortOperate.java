package com.huamiao.algorithm.ListNode;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2023/8/9
 * @since 1.0.0
 */
public class SortOperate {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a1 = new ListNode(8);
        ListNode a2 = new ListNode(6);
        ListNode a3 = new ListNode(9);
        ListNode a4 = new ListNode(6);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(2);
        head.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
//        ListNode listNode = fromTopToBottom(head, null);
        ListNode listNode = fromBottomToTop(head);
        while (listNode != null){
            System.out.println(listNode.value);
            listNode = listNode.next;
        }
    }

    static ListNode fromTopToBottom(ListNode head, ListNode tail){
        if(head == null){
            return head;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) fast = fast.next;
        }
        ListNode listNode1 = fromTopToBottom(head, slow);
        ListNode listNode2 = fromTopToBottom(slow, tail);

        return merge(listNode1, listNode2);
    }

    private static ListNode merge(ListNode listNode1, ListNode listNode2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while(listNode1 != null && listNode2 != null){
            if (listNode2.value > listNode1.value){
                cur.next = listNode1;
                listNode1 = listNode1.next;
            }else {
                cur.next = listNode2;
                listNode2 = listNode2.next;
            }
            cur = cur.next;
        }
        if (listNode1 != null)  cur.next = listNode1;
        if (listNode2 != null)  cur.next = listNode2;
        return dummyNode.next;
    }

    static ListNode fromBottomToTop(ListNode head){
        int len = 0;
        ListNode cur = head;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        ListNode dummyNode = new ListNode(0, head);
        for (int subLength = 1; subLength < len; subLength<<=1) {

            ListNode pre = dummyNode;
            cur = pre.next;
            while (cur != null){
                ListNode listNode1 = cur;
                int i = 1;
                while(i < subLength && cur.next != null){
                    i++;
                    cur = cur.next;
                }
                ListNode listNode2 = cur.next;
                cur.next = null;
                i = 1;
                cur = listNode2;
                while(i < subLength && cur != null && cur.next != null) {
                    i++;
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null){
                    next = cur.next;
                    cur.next = null;
                }

                ListNode merge = merge(listNode1, listNode2);
                pre.next = merge;
                while (pre.next != null){
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return dummyNode.next;
    }
}