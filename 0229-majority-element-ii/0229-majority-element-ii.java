class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        int el1 = 0;
        int el2 = 0;
        for(int i =0;i<nums.length;i++){
            if(c1 == 0 && nums[i] != el2){
                c1++;
                el1 = nums[i];
            }
            else if(c2 == 0 && nums[i] != el1){
                c2++;
                el2 = nums[i];
            }
           else if(nums[i] == el1){
                c1++;
            }
           else if(nums[i] == el2){
                c2++;
            }
            else{
                c1--;
                c2--;
            }

        }
        c1 = 0;c2 =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i] == el1){
                c1++;
            }else if(nums[i] == el2){
                c2++;
            }
        }
        int n = nums.length/3;
        List<Integer> ans = new ArrayList<>();
        if(n < c1){
            ans.add(el1);
        }
        if(n<c2){
            ans.add(el2);
        }
        return ans;
    }
}