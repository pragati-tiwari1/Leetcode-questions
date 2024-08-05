class Solution {
    public int trap(int[] height) {
        int ans =0;
        int leftmax = 0;
        int rightmax = 0;
        int l = 0;
        int r = height.length-1;
        while(l<=r){
            if(height[l]<=height[r]){
                if(leftmax <= height[l]){
                    leftmax = height[l];
                }else{
                    ans += leftmax-height[l];
                }
                l++;
            }else{
                if(rightmax <= height[r]){
                    rightmax = height[r];
                }else{
                    ans+=rightmax-height[r];
                }
                r--;
            }
        }
        return ans;
    }
}