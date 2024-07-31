class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int dp[] = new int[n+1];
        dp[0] = 0;//height
        dp[1] = books[0][1];
        for(int i =2;i<dp.length;i++){
            int rem =shelfWidth -  books[i-1][0];
            int max= books[i-1][1];
            int j = i-1;
            dp[i] = dp[i-1]+max;
          //  System.out.println(j);
            while(j>0 && rem - books[j-1][0]>=0){
                rem -= books[j-1][0];
                max = Math.max(max,books[j-1][1]);
                dp[i] = Math.min(dp[i],dp[j-1]+max);
                j--;
            }
          
        }
        return dp[n];
    }
}