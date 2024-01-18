package LinkedList;


//160
public class IntersectionofTwoLinkedList {
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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //sanity check
        if (headA == null || headB == null){
            return null;
        }

        ListNode p = headA;
        ListNode q = headB;

        // count lengths of a b
        int cnta = 0;
        int cntb = 0;
        while (p!=null){
            p = p.next;
            cnta++;
        }
        while (q!=null){
            q = q.next;
            cntb++;
        }

        // go to the aligned position
        p = headA;
        q = headB;
        if (cnta > cntb){
            for (int i = 0; i<(cnta-cntb); i++){
                p = p.next;
            }
        }

        if (cnta < cntb){
            for (int i = 0; i<(cntb-cnta); i++){
                q = q.next;
            }
        }

        // check the next and move
        while (p!=null && p!=q){
            p = p.next;
            q = q.next;
        }

        return p;
    }

    public static void main(String[] args) {
        ListNode heada = new ListNode(1);
        add(heada, 2);
        add(heada, 3);

        ListNode headb = new ListNode(2);
        headb.next = heada.next.next;
        System.out.println(getIntersectionNode(heada,headb).val);
    }
}
