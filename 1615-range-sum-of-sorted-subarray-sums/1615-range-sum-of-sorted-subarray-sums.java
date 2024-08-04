class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int ans[] = new int[(n*(n+1))/2];
        int k=0;
        for(int i =0;i<nums.length;i++){
            int sum=0;
            for(int j =i;j<nums.length;j++){
                sum+=nums[j];
                ans[k] = sum;
                k++;
            }
        }
        Arrays.sort(ans);
        int c=0;
        int mod = 1_000_000_007;
        for(int i =left-1;i<right;i++){
            c=(c+ans[i])%mod;
        }
        return c;
    }
}