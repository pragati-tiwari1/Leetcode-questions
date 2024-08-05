class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int max = 0;
        for(int i =0;i<=n;i++){
            while(!s.isEmpty() && ( (i==n) || heights[s.peek()]>=heights[i])){
                int h = heights[s.peek()];
                s.pop();
                int width=0;
                if(s.isEmpty()){
                    width = i;
                }else{
                    width = i-s.peek()-1;
                }
                max = Math.max(max,width*h);
            }
        s.push(i);
        }
        return max;
    }
}