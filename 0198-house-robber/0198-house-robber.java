class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+2];
        for(int i =2;i<dp.length;i++){
            int inc = nums[i-2]+dp[i-2];
            int exc = dp[i-1];
            dp[i] = Math.max(inc,exc);
        }
        return dp[nums.length+1];
    }
}