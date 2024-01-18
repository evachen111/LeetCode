package LinkedList;

// 203
public class RemoveLinkedListElements {

    public static void add(ListNode list, int value) {
        ListNode newNode = new ListNode(value);
        if (list == null){
            list = newNode;
            return;
        }

        ListNode p = list;

        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
        return;
    }

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
        System.out.print("]");
    }


    public static ListNode removeElements(ListNode head, int val) {
//        //case 3
//        while (head!= null && head.val == val){
//            head = head.next;
//        }
//        //case 2
//        if (head == null){
//            return head;
//        }
//        //case 1: head.val != val
//        ListNode p = head.next;
//        ListNode q = head;
//
//        while (p != null){
//            //check
//            if (p.val == val){
//                q.next = p.next;
//            }
//            else{
//                q = p;
//            }
//            p = p.next;
//        }
//        return head;

        // add a dummy node
        ListNode dummy = new ListNode(-1,head);
        ListNode p = dummy.next;
        ListNode q = dummy;
        while (p!=null){
            if (p.val == val){
                q.next = p.next;
            }
            else{
                q = p;
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(5);
        add(h, 5);
        add(h, 5);
        add(h, 5);

        printInArray(h);
        System.out.println("\n=========");
        printInArray(removeElements(h, 5));
    }
}

