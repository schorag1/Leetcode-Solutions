/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0, diff = 0;
        
        ListNode head1 = headA, head2 = headB;
        
        while(head1 != null){
            len1++;
            head1 = head1.next;
        }
        
        while(head2 != null){
            len2++;
            head2 = head2.next;
        }
        
        if(len1 < len2){
            head1 = headB;
            head2 = headA;
            diff = len2 - len1;
        }
        else{
            head1 = headA;
            head2 = headB;
            diff = len1 - len2;
        }
        
        for(int i = 0; i < diff; i++)
            head1 = head1.next;
        
        while(head1 != null && head2 != null){
            if(head1 == head2)
                return head1;
            
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return null;
    }
}