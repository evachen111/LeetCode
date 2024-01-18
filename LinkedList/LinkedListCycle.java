package LinkedList;


//142
public class LinkedListCycle {
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


    public static ListNode detectCycle(ListNode head) {
        // sanity check
        if (head == null){
            return null;
        }

//        // mark in an array
//        ListNode p = head;
//
//        int cnt = 0;
//        ListNode [] arr = new ListNode[10000];
//        while (p.next != null){
//            for (int i = 0; i< cnt; i++){
//                if (arr[i] == p.next){
//                    return p.next;
//                }
//            }
//            arr[cnt++] = p;
//            p = p.next;
//        }

        // fast slow pointers
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                ListNode index = head;
                while (index != slow){
                    index = index.next;
                    slow = slow.next;
                }
                return index;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        add(head, 2);
        add(head, 0);
        add(head, 4);
        head.next.next.next.next = head.next;
        System.out.println(detectCycle(head).val);
    }
}
