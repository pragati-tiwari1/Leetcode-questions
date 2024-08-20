class Solution {
    int f(int idx, int M, int isAliceTurn, int []piles, int [][][] dp){
        if(idx == piles.length) return 0;

        // Memoized Answer
        if(dp[idx][M][isAliceTurn] != -1) return dp[idx][M][isAliceTurn];
        
        // Current picks 1 to 2M
        int maxPickIndex = Math.min(piles.length-1, idx + 2*M - 1);

        // if its alice turn, pick some piles, try to maximize the answer
        if(isAliceTurn == 1){
            int ans = 0, currSum = 0, currPickedPiles = 0;
            for(int i=idx; i<=maxPickIndex; ++i){
                currSum += piles[i];
                currPickedPiles++;
                int newM = Math.max(M, currPickedPiles);

                ans = Math.max(ans, currSum + f(i+1, newM, 0, piles, dp));
            }

            return dp[idx][M][isAliceTurn] = ans;
        }

        // If its Bob turn, don't include the piles picked by bob and try to find the minimum
        int ans = (int)1e9, currPickedPiles = 0;
        for(int i=idx; i<=maxPickIndex; ++i){
            currPickedPiles++;
            int newM = Math.max(M, currPickedPiles);

            ans = Math.min(ans, f(i+1, newM, 1, piles, dp));
        }

        return dp[idx][M][isAliceTurn] = ans;
    }
    public int stoneGameII(int[] piles) {
        // Init Dp
        int dp[][][] = new int[piles.length][piles.length+1][2];
        for(int i=0; i<piles.length; ++i){
            for(int j=0; j<=piles.length; ++j){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return f(0, 1, 1, piles, dp);
    }
}