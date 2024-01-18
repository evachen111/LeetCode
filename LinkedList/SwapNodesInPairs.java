package LinkedList;

// 24
public class SwapNodesInPairs {

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

    public static ListNode swapPairs(ListNode head) {
        // sanity check
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = head.next;

        ListNode pre = new ListNode(0);
        ListNode cur = head;
        ListNode pos = head;

        while(pos != null){
            pos = pos.next;

            if (pos == null){
                break;
            }
            cur.next = pos.next;
            pos.next = cur;
            pre.next = pos;

            pre = cur;
            pos = cur.next;
            cur = cur.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        add(head, 2);
        add(head, 3);
        add(head, 4);
        add(head, 5);
        add(head, 6);
        printInArray(head);
        ListNode nn = swapPairs(head);
        printInArray(nn);
    }
}
