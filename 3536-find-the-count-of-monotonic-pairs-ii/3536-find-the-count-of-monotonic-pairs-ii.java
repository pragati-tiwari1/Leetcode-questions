class Solution {
    //TAKEN HELP
    public int countOfPairs(int[] nums) {
        int n = nums.length;
        int M = 1000000007;
        int dp[][] = new int[n+1][1005];
        for(int j =0;j<=nums[0];j++){
            dp[0][j] = 1;
        }
        for(int i =1;i<n;i++){//for all numbers

        int ways = 0;
        int prev_nums=0;
            for(int curr_nums=0;curr_nums<=nums[i];curr_nums++){
                    if(prev_nums<=Math.min(curr_nums,  nums[i-1]-nums[i] + curr_nums )){
                        ways = (ways%M + dp[i-1][prev_nums]%M)%M;
                        prev_nums++;
                    }
                      dp[i][curr_nums] = ways;
                }
              
            }
        int ans =0;
        for(int i = 0;i<=1000;i++){
            ans = (ans + dp[n-1][i]%M)%M;
        }
        return ans;
    }
}