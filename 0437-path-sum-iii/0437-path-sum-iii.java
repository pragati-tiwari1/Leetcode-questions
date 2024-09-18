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
    int c=0;
    public int pathSum(TreeNode root, int targetSum) {
        helper(root,targetSum,new ArrayList<>());
        return c;
    }
    public void helper(TreeNode root, int target, List<Integer> a){
        if(root == null){
            return;
        }
        a.add(root.val);
        helper(root.left,target,a);
        helper(root.right,target,a);
        long sum=0;
        for(int i = a.size()-1;i>=0;i--){
            sum+=a.get(i);
            if(sum == target){
                c++;
            }
        }
        a.remove(a.size()-1);
    }
}