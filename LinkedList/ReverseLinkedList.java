package LinkedList;


//206
public class ReverseLinkedList {

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


    public static ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
//        //recursive
//            // base case
//        if (head.next == null){
//            return head;
//        }
//            //recursion
//        ListNode newHead = reverseList(head.next);
//                // find the tail
//        ListNode p = newHead;
//        while (p.next != null){
//            p = p.next;
//        }
//        head.next = null; // essential!!!!!!!
//        p.next = head;
//
//        return newHead;

        // iterative
         //double pointers
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(); // ? val = 0 by default?
        ListNode head = new ListNode(1);
        add(head, 2);
        add(head, 3);
        add(head, 4);
        add(head, 5);
        printInArray(head);
        printInArray(reverseList(head));
    }
}
