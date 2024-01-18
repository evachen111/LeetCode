package LinkedList;


import java.util.List;

class ListNode{
    int val;
    ListNode next;

    public ListNode(){
    }

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

}




public class LinkedList {
    public static void add(ListNode list, int value) {

        if (list == null){
            list.val = value;
            return;
        }

        ListNode newNode = new ListNode(value);
        ListNode p = list;

        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
        return;
    }

    public static void printList(ListNode list){
        if (list == null){
            return;
        }

        ListNode p = list;

        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
        return;
    }

    public static void delete(ListNode list) {
        if (list == null){
            return;
        }

        if (list.next == null){
            list = null;
        }

        ListNode p = list;

        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;

        return;
    }



    public static void main(String[] args) {
        // generate a linklist
        ListNode head = new ListNode(12);
        add(head, 30);
        add(head, 3);
        printList(head);
        delete(head);
        System.out.println("========");
        printList(head);
    }
}
