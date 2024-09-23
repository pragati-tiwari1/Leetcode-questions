class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
       
        for(int i =0;i<dp.length;i++){
           // Arrays.fill(dp[i],-1);
            dp[i][i] = 1;
        }
        
        for(int i =0,c=0;c<s.length();c++){
            for(int j = c+1;j<s.length();j++,i++){
                //  System.out.println(i+" "+j);
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2+dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
            i=0;
        }
        return dp[0][s.length()-1];
        
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