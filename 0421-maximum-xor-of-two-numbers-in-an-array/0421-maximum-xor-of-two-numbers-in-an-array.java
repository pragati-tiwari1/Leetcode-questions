class Solution {
    class Node{
        Node child[] = new Node[2];
        Node(){
            for(int i =0;i<2;i++){
                child[i] = null;
            }
        }
    }
    Node root;
    public int findMaximumXOR(int[] nums) {
        root = new Node();
        int ans =0;
        for(int i=0;i<nums.length;i++){
            if(i == 0){
                insert(nums[i]);
            }else{
              ans = Math.max(ans,getMax(nums[i]));
                insert(nums[i]);
            }
        }
        return ans;
    }
    public void insert(int num){
        Node curr = root;
        for(int i=31;i>=0;i--){
            int bit = (num>>i )& 1;
            if(curr.child[bit] == null){
            curr.child[bit] = new Node();
            }
           curr = curr.child[bit];
        }
    }
    public int getMax(int num){
        Node curr = root;
        int ans = 0;
        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1;
            if(curr.child[1-bit] == null){
                curr = curr.child[bit];
            }else{
                 ans |= (1 << i);
                 curr = curr.child[1-bit];
            }
        }
        return ans;
    }
}