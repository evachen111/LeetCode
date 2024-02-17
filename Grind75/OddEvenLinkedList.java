package Grind75;

import java.util.LinkedList;
import java.util.List;

// 328
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        ListNode q = new ListNode();
        ListNode qhead = q;
        ListNode even;

        while (p!=null && p.next!=null){
            System.out.println(p.next.val);
            // find even
            even = p.next;
            // link odd
            p.next = even.next;
            even.next = null;
            // link even
            q.next = even;
            if (p.next!=null){
                p = p.next;
            }
            q = q.next;
        }
        p.next = qhead.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
