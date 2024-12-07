class Solution {
    //TAKEN HELP
//     To find no of operations required to divide A such that max balls in each bag is X.

// Say we want to divide 9 such that the max is 5, then to find the no of operations required.

// The number of bags reqd :
// ceil[9/5] = 2.
// To create 2 bags we need 2-1 = 1 operations.

// Now say we want to divide 9 such that the max is 3,
// No of bags reqd
// ceil[9/3] = 3
// No of operations required 3-1 = 2 operations

// So the formula is ceil((double) A/X) - 1
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = 0;
        for(int i =0;i<nums.length;i++){
            high = Math.max(high,nums[i]);
        }
        while(low<high){
            int mid = (low+high)/2;
            if(isPossible(mid,maxOperations,nums)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean isPossible(int val, int total, int nums[]){
        int req = 0;
        for(int i =0;i<nums.length;i++){
            req += Math.ceil(nums[i]/(double)val) - 1;
            if(req > total){
                return false;
            }
    }
    return true;
    }
}