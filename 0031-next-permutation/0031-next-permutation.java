class Solution {
    public void nextPermutation(int[] nums) {
        int c =0;
        for(int i =nums.length-1;i>0;i--){
            if(nums[i-1] < nums[i]){
                c++;
                //replace
                //find shortest x among i to n such that arr[i-1]<x
                int j = i;
                int x = Integer.MAX_VALUE;
                int idx =0;
                while(j<nums.length){
                    if(nums[j]>nums[i-1] && x>nums[j]){
                      x = nums[j];
                      idx = j;
                    }
                    j++;
                }
                int t = nums[i-1];
                nums[i-1] = nums[idx];
                nums[idx] = t;
                Arrays.sort(nums,i,nums.length);
                break;
            }
            
        }
        if(c == 0){
            Arrays.sort(nums);
        }
    
    }
}