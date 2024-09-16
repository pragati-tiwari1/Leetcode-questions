class Solution {
    public int superEggDrop(int e, int f) {
        int dp[][] = new int[e+1][f+1];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(dp,e,f);
    }
    public int helper(int dp[][], int e, int f){
        if(e == 0||e==1){
          return   f;
        }
        if(f == 0||f==1){
            return  f;
        }
        if(dp[e][f] != -1){
            return dp[e][f] ;
        }
        int min = Integer.MAX_VALUE;
        int l =1;
        int h = f;
        while(l<=h){
            int mid = (l+h)/2;
            int left = helper(dp,e-1,mid-1);//break
            int right = helper(dp,e,f-mid);//not break
            int temp = 1+Math.max(left,right);// +1 for attempt and max for number of attempts in worst case scenario
            if(left<right){
                l = mid+1;
            }else{
                h = mid-1;
            }
            min = Math.min(min,temp);
        }
        return dp[e][f] = min;
    }
}