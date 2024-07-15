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
    public TreeNode createBinaryTree(int[][] d) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
       HashSet<TreeNode> set = new HashSet<>();
        for(int i =0;i< d.length;i++){
            boolean l = d[i][2]==1?true:false;
            TreeNode p1 = null;
            if(!map.containsKey(d[i][0])){
                p1 = new TreeNode(d[i][0]);
                map.put(d[i][0],p1);
            }else{
                p1 = map.get(d[i][0]);
            }
            TreeNode c1 = null;
            if(!map.containsKey( d[i][1])){
                c1 = new TreeNode( d[i][1]);
                map.put( d[i][1],c1);
            }else{
                c1 = map.get( d[i][1]);
            }
            if(l){
                p1.left = c1;
            }else{
                p1.right = c1;
            }
         set.add(c1);
        }
       for(int i =0;i< d.length;i++){
        if(!set.contains(map.get(d[i][0]))){
            return map.get(d[i][0]);
        }
       }
       return null;
    }
}