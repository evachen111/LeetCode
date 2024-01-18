package Grind75;

import binaryTree.TreeNode;

import java.util.List;

// 2095
public class DeletetheMiddleNodeofaLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        // sanity check

        ListNode p = head.next;      //  when to use " = new ListNode();"?
        ListNode slow = head;
//        ListNode pre = new ListNode();     // by default, pre.val = 0; pre.next = null;
        ListNode pre = null;
        while (p!=null){
            pre = slow;
            slow = slow.next;
            p = p.next;
            if (p!=null){
                p = p.next;
            }
            else{
                break;
            }
        }

        if (pre == null){
            return pre;
        }
        // delete slow
        pre.next = slow.next;
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        DeletetheMiddleNodeofaLinkedList sol = new DeletetheMiddleNodeofaLinkedList();
        ListNode tree = new ListNode(1);
        ListNode head = sol.deleteMiddle(tree);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
