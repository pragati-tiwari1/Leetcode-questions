class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l =0;
        int h = nums.length-2;
        while(l<=h){
           
            int mid = (l+h)/2;
           if(nums[mid] == nums[mid^1]){//left -> 1st instance -> even ,2nd -> odd
                                        // on doing mid^1 if mid is even then it will calculate mid+1 ,if odd then mid-1
             l = mid+1;

           }else{
            h = mid-1;
           }
        }
        return nums[l];
    }
}