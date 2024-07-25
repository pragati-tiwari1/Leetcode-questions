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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      return  helper(preorder,inorder,0,0,inorder.length-1);
    }
    public TreeNode helper(int[] preorder, int[] inorder,int idx,int s,int e){
        if(s>e){
            return null;
        }
        int inIdx = -1;
        for(int i = s;i<=e;i++){
            if(inorder[i] == preorder[idx]){
                inIdx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[idx]);
        root.left = helper(preorder,inorder,idx+1 , s,inIdx-1);
        int l = inIdx-1-s+1;
        root.right = helper(preorder,inorder,l+idx+1, inIdx+1,e);
        return root;
    }
}