/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (a,b) -> Integer.compare(a.val, b.val));
        
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        
        for(ListNode list: lists){
            if(list != null)
                pq.add(list);
        }
        
        while(!pq.isEmpty()){
            temp.next = pq.poll();
            temp = temp.next;
            
            if(temp.next != null)
                pq.add(temp.next);
        }
        
        return dummy.next;
    }
}