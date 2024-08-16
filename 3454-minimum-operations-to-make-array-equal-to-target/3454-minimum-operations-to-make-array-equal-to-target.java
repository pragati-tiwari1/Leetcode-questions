class Solution {
    //TAKEN HELP
    public long minimumOperations(int[] nums, int[] target) {
        int diff = 0;//curr diff
        int incr = 0;//how much we have icremented previously
        int decr = 0;
        long ops = 0;//total operation required

        for(int i =0;i<nums.length;i++){
            diff = target[i]-nums[i];
            if(diff > 0){//increment
             if(incr < diff){//we need more increment
                ops += diff - incr;
             }
            incr = diff;
            decr = 0;
            }
            if(diff < 0){//decrement
                 if(decr > diff){//we need more increment
                ops += decr - diff;
             }
            incr = 0;
            decr = diff;
            }
            if( diff == 0){
                incr = 0;
                decr = 0;
            }
        }
        return ops;
    }
}