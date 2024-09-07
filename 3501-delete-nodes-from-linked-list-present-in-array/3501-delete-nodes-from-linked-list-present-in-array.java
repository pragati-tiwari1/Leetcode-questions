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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            set.add(nums[i]);
        }
        while(temp!=null){
            if(set.contains(temp.val) && temp.val == head.val){
                head = head.next;
            }
            else if(set.contains(temp.val)){
                prev.next = temp.next;
            }else{
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}