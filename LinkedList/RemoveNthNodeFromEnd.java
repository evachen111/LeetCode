package LinkedList;

// 19
public class RemoveNthNodeFromEnd {
    public static void printInArray(ListNode head){
        if (head == null){
            System.out.println("[]");
            return;
        }

        System.out.print("[");
        System.out.print(head.val);
        ListNode p = head.next;
        while (p != null) {
            System.out.print("," + p.val);
            p = p.next;
        }
        System.out.print("]\n");
    }

    public static void add(ListNode list, int value) {
        ListNode newNode = new ListNode(value);
        if (list == null){
            list.val = value;
            return;
        }

        ListNode p = list;

        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
        return;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // sanity check
        if (head == null){
            return head;
        }
        ListNode pre = new ListNode(-1,head);
        ListNode newNode = pre;
        ListNode cur = head;
        ListNode pos = head;
        // go n steps first
            // or go n+1 steps first, use only 2 pointers
        for (int i = 0; i<n; i++){
            pos = pos.next;
        }

        // find the end
        while (pos != null){
            cur = cur.next;
            pre = pre.next;
            pos = pos.next;
        }

        // delete the current node
        pre.next = cur.next;

        return newNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        add(head, 2);
        add(head, 3);
        add(head, 4);
        add(head, 5);
        printInArray(head);
        printInArray(removeNthFromEnd(head, 2));
    }
}
