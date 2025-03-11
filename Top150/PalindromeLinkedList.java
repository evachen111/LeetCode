package Top150;

import java.util.Stack;

// 234
public class PalindromeLinkedList {
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
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

    public boolean isPalindrome(ListNode head) {
//        Stack<Integer> stack = new Stack<>();
//        while (head != null){
//            if (stack.isEmpty() || stack.peek() != head.val){
//                stack.push(head.val);
//            }
//            else if (stack.peek() == head.val){
//                stack.pop();
//            }
//            head = head.next;
//        }
//        return stack.isEmpty();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        while (head != null && slow != null){
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);

        PalindromeLinkedList sol = new PalindromeLinkedList();
        System.out.println(sol.isPalindrome(head));
    }
}
