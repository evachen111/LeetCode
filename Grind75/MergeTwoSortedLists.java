package Grind75;

import java.util.List;

// 21
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // sanity check
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        // find the new root
        // dummy root
        ListNode root = new ListNode();
        ListNode root1 = root;
        ListNode p = list1;
        ListNode q = list2;
        // compare and link
        while (p!=null && q!=null){
            if (p.val <= q.val){
                root.next = p;
                p = p.next;
            }
            else{
                root.next = q;
                q = q.next;
            }
            root = root.next;
        }
        if (p == null){
            root.next = q;
        }
        if (q == null){
            root.next = p;
        }

        // return new root
        return root1.next;
    }
}
