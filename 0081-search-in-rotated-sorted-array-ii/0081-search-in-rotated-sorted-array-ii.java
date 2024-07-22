class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid]==nums[l]&&nums[h]==nums[mid]){
                l = l+1;
                h = h-1;
                continue;
            }
              System.out.println(mid);
             
            if(nums[mid] >= nums[l] && nums[mid] > nums[h]){//rotated portion
          
                if(nums[l]<=target && nums[mid]>=target){
                    h = mid-1;
                }else{
                    l = mid+1;
                }
            }
            else{//original
                if(nums[h]>=target && nums[mid]<=target){
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }
        }
        return false;
    }
}