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
   
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s  = new StringBuilder();
        StringBuilder d  = new StringBuilder();

       helper(root,startValue,s);
       helper(root,destValue,d);
      int max_i = Math.min(d.length(), s.length());
      int i =0;
        while (i < max_i && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1))
            ++i;

       System.out.println(d);
       String s1 = s.toString();
       String res = "";
       int c =0;
       while(c<s1.length()-i){
        res+='U';
        c++;
       }
       res+=d.reverse().toString().substring(i);
       return res;
    }
  
    public boolean helper(TreeNode root, int destValue,
    StringBuilder curr ){
        if(root == null){
            return false;
        }
        
        if(root.val == destValue){
           return true;
        }
        if(root.left!=null && helper(root.left,destValue,curr) ){
           curr.append('L');
        }
       else if(root.right!=null &&  helper(root.right,destValue,curr)){
            curr.append('R');
        }
        return curr.length() >0;
    }
}