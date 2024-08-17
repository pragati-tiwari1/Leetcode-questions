class Solution {
    public int maximumLength(int[] nums) {
        int odd=0;
        int even = 0;
        int both = 1;
        int last = -1;
        for(int i =0;i<nums.length;i++){
            int n = nums[i];
            if(n%2 == 0){
                even++;
                if(last == 1){
                    both++;
                }
                last =0;
            }
            else{
                odd++;
                 if(last == 0){
                    both++;
                }
                last = 1;
            }
        }
        return Math.max(odd,Math.max(even,both));
    }
}