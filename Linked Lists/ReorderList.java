/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        ListNode prev = null;
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode temp1 = head;
        ListNode temp2 = reverse(slow);
        
        merge(temp1, temp2);
    }
    
    private ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        
        while(temp != null){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
    
    private void merge(ListNode temp1, ListNode temp2){
        while(temp1 != null){
            ListNode n1 = temp1.next;
            ListNode n2 = temp2.next;
            
            temp1.next = temp2;
            
            if(n1 == null)
                break;
            
            temp2.next = n1;
            temp1 = n1;
            temp2 = n2;
        }
    }
}