class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0 && word2.length() == 0){
            return 0;
        }
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        dp[0][0] = 0;
        return lcs(word1,word2,word1.length(),word2.length(),dp);
    }
    public int lcs(String word1, String word2, int i, int j,int dp[][]){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i == 0&&j==0){
            return 0;
        }
        if(i<=0 ){
            return j;
        }
        if(j<=0){
            return i;
        }
        if(word1.charAt(i-1) == word2.charAt(j-1)){
         return dp[i][j]= lcs(word1,word2,i-1,j-1,dp);
        }else{
            int add = lcs(word1,word2,i-1,j,dp)+1;
            int rep = lcs(word1,word2,i-1,j-1,dp)+1;
            int del = lcs(word1,word2,i,j-1,dp)+1;
            return dp[i][j]= Math.min(add,Math.min(del,rep));
        }
    }
}