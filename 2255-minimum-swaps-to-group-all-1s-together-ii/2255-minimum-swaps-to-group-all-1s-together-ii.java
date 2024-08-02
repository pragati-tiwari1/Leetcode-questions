class Solution {
    public int minSwaps(int[] nums) {
        int c=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==1){
                c++;
            }
        }
        int l =0;
        int r = l+c-1;
        int min = Integer.MAX_VALUE;
        int zero =0;
        for(int i =l;i<=r;i++){
            if(nums[i] == 0){
                zero++;
            }
        }
        l++;
        r= (r+1)%nums.length;
        min = Math.min(min,zero);
        while(l<nums.length){
            if(nums[l-1] == 0){
                zero--;
            }
            if(nums[r] == 0){
                zero++;
            }
            min = Math.min(min,zero);
             l++;
        r= (r+1)%nums.length;
        }
        return min;

    }
}