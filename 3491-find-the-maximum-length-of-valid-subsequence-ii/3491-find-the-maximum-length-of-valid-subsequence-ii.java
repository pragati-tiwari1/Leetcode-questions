class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int dp[][] = new int[n][k];
        int max=0;
        for(int i =1;i<dp.length;i++){
            int curr = nums[i];
            for(int j = i-1;j>=0;j--){
                int r = (curr+nums[j])%k;
                dp[i][r] = Math.max(dp[j][r]+1,dp[i][r]);
                max = Math.max(dp[i][r],max);
            }
        }
        return max+1;
    }
}