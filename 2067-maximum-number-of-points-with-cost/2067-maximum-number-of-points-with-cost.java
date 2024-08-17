class Solution {
    public long maxPoints(int[][] points) {
    
        long dp[][] = new long[points.length][points[0].length];
        long max =0;
        for(int i =0;i<points[0].length;i++){
             dp[0][i] = points[0][i];
            }
            
        for(int i =1;i<points.length;i++){
            //max = 0;
            for(int j =0;j<points[0].length;j++){
                 max = 0;
                int curr = points[i][j];
               for(int k =0;k<dp[0].length;k++){
                max = Math.max(max,curr+dp[i-1][k]-Math.abs(j-k));
               }
               dp[i][j] = max;
            }
            // System.out.println(" ");
        }
        
        long ans =0;
        for(int i =0;i<dp[0].length;i++){
            ans = Math.max(dp[dp.length-1][i],ans);
        }
        return ans;
    }
}