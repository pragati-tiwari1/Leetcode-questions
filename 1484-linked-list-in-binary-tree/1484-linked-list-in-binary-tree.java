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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return find(head,root);
    }
    public boolean find(ListNode head, TreeNode root){
        if(root == null){
            return false;
        }
        if(root.val == head.val){
            if(search(root,head)){
                return true;
            }
        }
        boolean left = find(head,root.left);
        boolean right = find(head,root.right);
        return left || right;
    }
    public boolean search(TreeNode root, ListNode head){
        if( head == null){
            return true;
        }
        if(root == null ){
            return false;
        }
        if(root.val != head.val){
            return false;
        }
        return search(root.left,head.next) || search(root.right,head.next);
    }
}