class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums,ans,0,temp);
        return ans;
    }
    public void helper(int[] nums, List<List<Integer>> ans ,int i , List<Integer> temp ){
        if(i >= nums.length){
            ans.add(new ArrayList<>(temp));
            return ;
        }
        //include
        temp.add(nums[i]);
        helper(nums,ans,i+1,temp);

        temp.remove(temp.size()-1);

        //exclude
        helper(nums,ans,i+1,temp);

        return;
    }
}