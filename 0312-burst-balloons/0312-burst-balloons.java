class Solution {
    public int maxCoins(int[] nums) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        for(int i =0;i<nums.length;i++){
            a.add(nums[i]);
        }
        a.add(1);
        int n = nums.length;
        int dp[][] = new int[n+2][n+2];
        for(int i =0;i<n+2;i++){
            Arrays.fill(dp[i],-1);
        }
        return maxCoins(a,dp,1,n);
    }
    public int maxCoins(ArrayList<Integer> a ,int dp[][] ,int s, int e){
        if(s>e){
            return 0;
        }
        if(dp[s][e]!= -1){
            return dp[s][e];
        }
        int max = 0;
        for(int idx = s;idx<=e;idx++){
            int cost = a.get(idx)*a.get(s-1)*a.get(e+1)
            +maxCoins(a,dp,s,idx-1)+maxCoins(a,dp,idx+1,e);
            max = Math.max(cost,max);
        }
        return dp[s][e] = max;
    }
}