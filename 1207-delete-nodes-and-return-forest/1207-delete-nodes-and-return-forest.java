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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<TreeNode> ans = new HashSet<>();
        ans.add(root);
        HashSet<Integer> del = new HashSet<>();
        for(int i =0;i<to_delete.length;i++){
            del.add(to_delete[i]);
        }
        helper(root,null,false,ans,del);
        List<TreeNode> res = new ArrayList<>();
        for(TreeNode t:ans){
            res.add(t);
        }
        return res;
    }
    public void helper(TreeNode root,TreeNode par,boolean left,HashSet<TreeNode> ans
     , HashSet<Integer> del){
        if(root == null){
            return;
        }
        if(del.contains(root.val)){
            if(ans.contains(root)){
                ans.remove(root);
            }
            if(par!=null){
                if(left){
                    par.left = null;
                }else{
                    par.right = null;
                }
            }
            if(root.left!=null){
                ans.add(root.left);
            }
            if(root.right != null){
                ans.add(root.right);
            }
            helper(root.left,null,false,ans,del);
            helper(root.right,null,false,ans,del);

        }
            helper(root.left,root,true,ans,del);
            helper(root.right,root,false,ans,del);
        return;

     }
}