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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int total = helper(root);
        return Math.max(max,total);
    }
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        int m = Math.max(root.val,Math.max(l+root.val,Math.max(r+root.val,l+r+root.val)));
        max = Math.max(m,max);
        int ret = Math.max(root.val,Math.max(l,r)+root.val);
        return ret;
    }
}