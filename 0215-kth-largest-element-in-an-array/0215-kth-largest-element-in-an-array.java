class Solution {
    //QUICK SELECT 
    //TAKEN HELP
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length-1;
        int ans = 0;
        while(true){
            int idx = partition(nums,l,r);
            System.out.println(idx);
            if(idx == k-1 ){
               ans = nums[idx];
               break;
            }
            if(idx < k-1){
                l = idx+1;
            }else{
                r = idx-1;
            }
        }
        return ans;
    }
    //sort in descending order
    public int partition(int nums[],int left,int r){
        int pivot = nums[left];
        int l = left+1;
        while(l<=r){
            if(pivot > nums[l] && nums[r] > pivot){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
            if(pivot >= nums[r]){
                r--;
            }
            if(pivot <= nums[l]){
                l++;
            }
        }
        int temp = pivot ;
        nums[left] = nums[r];
        nums[r] = pivot;
        return r;
    }

}