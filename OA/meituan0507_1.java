package OA;
import Top150.TreeNode;

import java.util.List;

public class meituan0507_1 {
    public ListNode reOrderList(ListNode head, int k) {
        //new linked list with fake head, init: newHead--null
        ListNode newHead = new ListNode(0);
        ListNode newp = newHead;
        ListNode p = head;
        // q follows p, init: q--head
        ListNode q = new ListNode(0);
        head = q;
        q.next = p;

        // go through the linked list
        while (p != null) {
            if (p.val >= k){
                newp.next = p;
                newp = newp.next;
                q.next = p.next;
                p.next = null;
            }
            else{
                q = p;
            }
            p = q.next;
        }
        q.next = newHead.next;
        return head.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(6);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        meituan0507_1 m = new meituan0507_1();

        ListNode res = m.reOrderList(head, 5);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
