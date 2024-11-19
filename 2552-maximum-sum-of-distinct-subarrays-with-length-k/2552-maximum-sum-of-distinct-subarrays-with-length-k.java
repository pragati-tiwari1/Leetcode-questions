class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        HashSet<Integer> set = new HashSet<>();
        int l =0;
        int r = 0;
        while(l<nums.length && r<nums.length){
            while(set.contains(nums[r])){
                sum-=nums[l];
                set.remove(nums[l]);
                l++;
            }
           set.add(nums[r]);
           sum+=nums[r];
            if(r-l+1 == k){
                ans = Math.max(sum,ans);
                 sum-=nums[l];
                set.remove(nums[l]);
                l++;
            }
           
            r++;
        }
        
        return ans;
    }
}