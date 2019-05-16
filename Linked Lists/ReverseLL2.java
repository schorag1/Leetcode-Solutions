/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return head;
        
        ListNode current = head;
        ListNode prev = null;
        
        while(m > 1){
            prev = current;
            current = current.next;
            m--;
            n--;
        }
        
        ListNode connect = prev;
        ListNode tail = current;
        
        ListNode third = null;
        while(n > 0){
            third = current.next;
            current.next = prev;
            prev = current;
            current = third;
            n--;
        }
        
        if(connect != null)
            connect.next = prev;
        else
            head = prev;
        
        tail.next = current;
        
        return head;
    }
}