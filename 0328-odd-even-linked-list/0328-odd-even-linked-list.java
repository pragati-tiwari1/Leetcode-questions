/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head== null || head.next == null ||  head.next.next == null){
            return head;
        }
        ListNode n = head.next;
        ListNode old = head.next;

       ListNode h = head;
       ListNode prev = null;

       while(h!=null && n!=null && h.next!=null && n.next!=null ){
        h.next = h.next.next;
        h= h.next;
         prev = n.next;
        n.next = n.next.next;
        n = n.next;
       }
       prev.next = old;
       return head;
        
    }
   
}