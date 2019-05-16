/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null){
            int temp = 0;
            if(l1 != null)
                temp += l1.val;
            if(l2 != null)
                temp += l2.val;
            temp += carry;
            
            ListNode node = new ListNode(temp%10);
            carry = temp/10;
            
            prev.next = node;
            prev = node;
            
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        
        if(carry > 0)
            prev.next = new ListNode(carry);
        
        return reverse(dummy.next);
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
    }
}