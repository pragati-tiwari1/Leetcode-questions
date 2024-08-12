class Solution {
    //TAKEN HELP
    public int countOfPairs(int[] nums) {
        long ans = helper(0,0,50,nums);
        return (int)ans;
    }
    HashMap<String,Long> map = new HashMap<>();
    public long helper(int i, int s, int e , int []nums){
        if(i == nums.length){
            return 1;
        }
        String key = s+"-"+e+"-"+i;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int j = s;
        int k = e;
        long ans =0;
        while(j<=nums[i] && k>=0){
            int sum = j+k;
            if(sum == nums[i]){
                ans = (ans+ helper(i+1,j,k,nums))%1000000007;
                j++;
                k--;
            }
            else if(sum < nums[i]){
                j++;
            }else{
                k--;
            }
        }
        map.put(key,ans);
        return ans;
    }
}