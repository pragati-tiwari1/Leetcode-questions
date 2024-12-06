class Solution {
    public static int trap(int heights[]){
        //calculate left max boundary
        int leftmax[] = new int[heights.length];
        leftmax[0] = heights[0];
        for(int i=1; i<heights.length; i++){
            leftmax[i] = Math.max(heights[i], leftmax[i-1]);
        }

        //calculate right max boundary
        int rightmax[] = new int[heights.length];
        rightmax[heights.length-1] = heights[heights.length-1];
        for(int i=heights.length-2; i>=0; i--){
            rightmax[i] = Math.max(heights[i], rightmax[i+1]);
        }

        //loop
        int trappedWater = 0;
        for(int i=0; i<heights.length; i++){
            //water level = min(left max boundary, right max boundary)
            int waterlevel = Math.min(leftmax[i], rightmax[i]);

            //trapped water = (water level - height[i])*width
            trappedWater += waterlevel - heights[i];
        }
        return trappedWater;
    }

   
}