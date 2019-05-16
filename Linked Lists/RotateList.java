/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        
        ListNode oldTail = head;
        
        int n = 1;
        while(oldTail.next != null){
            oldTail = oldTail.next;
            n++;
        }
        oldTail.next = head;
        
        ListNode newTail = head;
        for(int i=0; i < n - k % n-1; i++)
            newTail = newTail.next;
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}