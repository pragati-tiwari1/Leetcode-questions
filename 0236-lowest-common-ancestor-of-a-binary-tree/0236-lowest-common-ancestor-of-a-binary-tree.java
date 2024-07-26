/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = root;
        lca(root,p,q);
        return ans;
    }
    public boolean lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        boolean curr = false;
        if(root == p || root == q){
            curr = true;
        }
        boolean left = lca(root.left,p,q);
        boolean right = lca(root.right,p,q);
        if((left && right)|| (left && curr) || right && curr ){
            ans = root;
            return false;
        }
        if(curr){
            return curr;
        }
        return left || right;
    }     
    
}