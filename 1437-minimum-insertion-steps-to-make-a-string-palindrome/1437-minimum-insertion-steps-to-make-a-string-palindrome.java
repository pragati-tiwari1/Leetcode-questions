class Solution {
    public int minInsertions(String s) {
        int l =0;
        int h = s.length()-1;
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i =0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(s,l,h,dp);
    }
    public int helper(String s, int l, int h,int dp[][] ){
        if(l>h){
            return 0;
        }
       
        if(l == h){
            return 0;
        }
        if(dp[l][h]!=-1){
            return dp[l][h];
        }
        char ch1 = s.charAt(l);
        char ch2 = s.charAt(h);
        int c=0;
        if(ch1 == ch2){
           //  System.out.println(ch1+" "+ch2);
           c=helper(s,l+1,h-1,dp);
        }  
        else{
            c=1+Math.min(helper(s,l+1,h,dp),helper(s,l,h-1,dp));
        }
      return dp[l][h] = c;

    }
}