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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len =0;
        ListNode temp = head;
        while(temp!= null){
            temp = temp.next;
            len++;
        }
        int parts =0;
        int start = 0;
        int slen = 0;
        if(len <= k){
            parts = 1;
        }else{
            parts = len/k;
            if(len%k !=0){
                start = parts+1;
                slen = len%k;
            }
        }
        ListNode[] ans = new ListNode[k];
        Arrays.fill(ans,null);
        temp = head;
        int c=0;
        int i =0;
        ListNode h1 = head;
        while(temp != null){
            c++;
            if(slen != 0 && c == start){
                ans[i] = h1;
                h1 = temp.next;
                temp.next = null;
                temp = h1;
                c=0;
                i++;
                slen--;
            }
            else if(slen == 0 && c == parts){
                ans[i] = h1;
                i++;
                h1 = temp.next;
                temp.next = null;
                temp = h1;
                c=0;
            }
            else{
                temp = temp.next;
            }
        }
        return ans;
    }
}