class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
       
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
            dp[i][i] = 1;
        }
         dp[0][0] = 0;
        int max  = 0;
        for(int idx = 1;idx<=n;idx++){
            int a = helper(s,idx,idx+1,dp);
            int b = helper(s,idx-1,idx+1,dp)+1;
            max = Math.max(max,Math.max(a,b));
        }
        return max;
    }
    public int helper(String s, int i,int j,int dp[][]){
        if(i == 0 ||j > s.length()){
            return 0;
        }
        if(dp[i][j]!= -1){
            return dp[i][j];
        }
        if(s.charAt(i-1) == s.charAt(j-1)){
            return dp[i][j] =  helper(s,i-1,j+1,dp)+2;
        }else{
            int a = helper(s,i,j+1,dp);
            int b = helper(s,i-1,j,dp);
            return dp[i][j] = Math.max(a,b);
        }
    }
}