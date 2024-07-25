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
    int max =0;
    public int diameterOfBinaryTree(TreeNode root) {
       int t = helper(root);
        return Math.max(t,max);
    }
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        int c = 0;
        if(root.left != null){
            c+=1;
        }
        if(root.right != null){
            c+=1;
        }
        max = Math.max(l+r+c,max);
        return Math.max(l,r)+1;
    }
}