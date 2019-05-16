/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int target) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode temp = head;
        
        while(temp != null){
            if(temp.val == target)
                prev.next = temp.next;
            else
                prev = prev.next;
            
            temp = temp.next;
        }
        
        return dummy.next;
    }
}