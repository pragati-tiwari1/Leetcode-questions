class Solution {
    public int findMin(int[] nums) {
       int ans = Integer.MAX_VALUE;
       int l =0;
       int h = nums.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            ans = Math.min(ans,nums[mid]);
            if(nums[mid]>=nums[l] && nums[mid]>=nums[h]){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return ans;
    }
}