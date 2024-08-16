class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int idx =-1;
        int l = -1;
        for(int i =0;i<arrays.size();i++){
            if(min > arrays.get(i).get(0)){
                min = arrays.get(i).get(0);
                idx = i;
            }
            if( max < arrays.get(i).get(arrays.get(i).size()-1)){
                max = arrays.get(i).get(arrays.get(i).size()-1);
                l = i;
            }
        }
        if(l != idx){
            return Math.abs(max-min);
        }
        int ans=0;
       
        for(int i =0;i<arrays.size();i++){
            if(i != l){
                ans = Math.max(ans, Math.abs(max - arrays.get(i).get(0)));
            }
            if(i != idx){
                ans = Math.max(ans,Math.abs( min - arrays.get(i).get(arrays.get(i).size()-1)));
            }
        }
        
        return ans;
    }
}