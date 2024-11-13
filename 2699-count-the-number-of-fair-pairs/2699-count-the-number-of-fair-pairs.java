class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long c = 0;
        Arrays.sort(nums);
        for(int i =0;i<nums.length-1;i++){
            int min_val = lower - nums[i];
            int max_val = upper - nums[i];
            int minIdx = lowerBound(nums,i+1,min_val);
            int maxIdx = upperBound(nums,i+1,max_val);
            c += (maxIdx-minIdx);
        }
        return c;
    }
    public int lowerBound(int[] nums, int idx, int target){
        int l = idx;
        int h = nums.length;
        int ans = 0;
        while(l<h){
            int mid = (l+h)/2;
            if(target > nums[mid]){
                l = mid+1;
            }
            else{
                h = mid;
            }
        }
        return l;
    }
    public int upperBound(int[] nums, int idx, int target){
        int l = idx;
        int h = nums.length;
        int ans = 0;
        while(l<h){
            int mid = (l+h)/2;
            if(target >= nums[mid]){
                l = mid+1;
            }
            else{
                h = mid;
            }
        }
        return l;
    }
}