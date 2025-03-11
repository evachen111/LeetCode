package Top150;

// 206
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // sanity check
        if (head == null){
            return head;
        }
        ListNode post = null;
        ListNode pre;
        while (head != null){
            pre = head.next;
            head.next = post;
            post = head;
            head = pre;
        }
        return post;
    }

    public static void main(String[] args) {

    }
}
