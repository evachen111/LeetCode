package Top150;

// 141
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // sanity check
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
