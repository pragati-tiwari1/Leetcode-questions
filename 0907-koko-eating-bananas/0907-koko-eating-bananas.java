class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        Arrays.sort(piles);
        int ans = 0;
        int high = piles[piles.length-1];
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(mid,piles,h)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int x,int[] piles, int h){
       long c=0;
        for(int i =0;i<piles.length;i++){
            if(piles[i] <=x){
                c++;
            }
           else if(piles[i]%x==0){
            c += piles[i]/x;
           }
           else{
            c+= (piles[i]/x)+1;
           }
        }
        if(c <= h){
            return true;
        }
        
        return false;
    }
}