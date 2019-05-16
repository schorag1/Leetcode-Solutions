/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null, slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        return merge(left, right);
    }
    
    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        
        while(left != null && right != null){
            if(left.val < right.val){
                prev.next = left;
                left = left.next;
            }
            else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }
        
        if(left != null)
            prev.next = left;
        
        if(right != null)
            prev.next = right;
        
        return dummy.next;
    }
}