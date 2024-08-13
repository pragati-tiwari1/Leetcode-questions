class Solution {
    //TAKEN HELP
    public int countOfPairs(int[] nums) {
        int n = nums.length;
        int M = 1000000007;
        int dp[][] = new int[n+1][55];
        for(int j =0;j<=nums[0];j++){
            dp[0][j] = 1;
        }
        for(int i =1;i<n;i++){//for all numbers
            for(int curr_nums=0;curr_nums<=nums[i];curr_nums++){
                int ways = 0;
                for(int prev_nums = 0;prev_nums<=50;prev_nums++){
                    if(curr_nums>=prev_nums && nums[i] - curr_nums <= nums[i-1] - prev_nums){
                        ways = (ways%M + dp[i-1][prev_nums]%M)%M;
                    }
                }
                dp[i][curr_nums] = ways;
            }

        }
        int ans =0;
        for(int i = 0;i<=50;i++){
            ans = (ans + dp[n-1][i]%M)%M;
        }
        return ans;
    }
    
}