package LinkedList;

// 25
public class ReverseNodesInKGroup {
    public static int findNextHead(ListNode head, int k) {
        int cnt = 0;
        ListNode cur = head;
        while (cur != null && cnt<k) {
            cur = cur.next;
            cnt++;
        }
        if (cnt == k) {
            return cnt;
        }
        return 0;
    }

    public static ListNode reverse(ListNode tail, ListNode head, int k) {
        ListNode cur = head;
        ListNode newhead = null;
        for (int i = 0; i < k; i++) {
            cur = head;
            head = head.next;
            cur.next = newhead;
            newhead = cur;
        }
        tail.next = newhead;
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1){
            return head;
        }
        ListNode tail = new ListNode(0);
        ListNode result = tail;
        while (findNextHead(head, k) ==k && head!=null) {
            head = reverse(tail, head, k);
            while (tail.next != null) {
                tail = tail.next;
            }
        }
        tail.next = head;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseNodesInKGroup sol = new ReverseNodesInKGroup();
        ListNode result = sol.reverseKGroup(head, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
