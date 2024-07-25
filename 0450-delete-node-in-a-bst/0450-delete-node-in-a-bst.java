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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }
        //    else if(root.left == null){
        //        root.val = root.right.val;
        //      root.right =   deleteNode(root.right,root.right.val);
        //        return root;
        //     }
            if(root.right == null){
                TreeNode curr = root.left;
                TreeNode prev = root;
                int c=0;
               while(curr.right!=null){
                c++;
                prev = curr;
                curr = curr.right;
               }
               root.val = curr.val;
               if(c==0){
                prev.left = deleteNode(curr,curr.val);
               }else{
                prev.right = deleteNode(curr,curr.val);
               }
               return root;
            }
            else{
                int del = inorder(root,root.right);
                root.val = del;
                return root;
            }
        }
        root.left = deleteNode(root.left,key);
        root.right = deleteNode(root.right,key);
        return root;
    }
    public int inorder(TreeNode prev,TreeNode curr){
       int c=0;
        while(curr.left != null){
            c++;
            prev = curr;
            curr = curr.left;
        }
        int r = curr.val;
        if(c == 0){
            prev.right = deleteNode(curr,curr.val);
        }else{
       prev.left =  deleteNode(curr,curr.val);
        }
        return r;
    }
}