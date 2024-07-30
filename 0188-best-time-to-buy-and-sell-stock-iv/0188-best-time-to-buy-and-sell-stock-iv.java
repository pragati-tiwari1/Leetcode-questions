class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][2][k+1];
        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
               Arrays.fill(dp[i][j],-1);
            }
        }
        return maxProfit(0,k,0,prices,dp);
    }
    //lastBuy-> 0 means you can buy
    public int maxProfit(int idx,int cap, int lastBuy, int[] prices, 
    int dp[][][] ){
        if(idx == prices.length || cap == 0){
            return 0;
        }
        
        if(dp[idx][lastBuy][cap]!= -1){
            return dp[idx][lastBuy][cap];
        }
        int max;
        int inc = 0;
        int exc = 0;
        //include
        if(lastBuy == 0 ){
         inc = maxProfit(idx+1,cap,1,prices,dp)-prices[idx];
          exc =  maxProfit(idx+1,cap,lastBuy,prices,dp);

        }else{
           exc = maxProfit(idx+1,cap,lastBuy,prices,dp);
           inc = maxProfit(idx+1,cap-1,0,prices,dp)+prices[idx];
        }
        max = Math.max(inc,exc);
        return dp[idx][lastBuy][cap] =  max;
    }
}