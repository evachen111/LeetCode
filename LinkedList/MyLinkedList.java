package LinkedList;

// 707. Design Linked List
public class MyLinkedList {

    public MyLinkedList() {

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
        System.out.print("]\n");
    }

    // singly
    ListNode head;
    public int get(int index) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy;
        for (int i = 0; i<=index; i++){
            p = p.next;
            if (p == null){
                return -1;
            }
        }
        return p.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val, head);
        head = newNode;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val, null);
        // empty list
        if (head == null){
            head = newNode;
            return;
        }
        ListNode p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode newNode = new ListNode(val);
        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = 0; i<=index; i++){
            if (p == null){
                return;
            }
            q = p;
            p = p.next;
        }
        q.next = newNode;
        newNode.next = p;
        head = dummy.next;
    }

    public void deleteAtIndex(int index) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = 0; i<=index; i++){
            q = p;
            p = p.next;
            if (p == null){
                return;
            }
        }
        q.next = p.next;
        head = dummy.next;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        printInArray(myLinkedList.head);
        myLinkedList.addAtIndex(1, 2);
        printInArray(myLinkedList.head);
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(0);
        printInArray(myLinkedList.head);
        System.out.println(myLinkedList.get(0));
    }
}
