class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nsl[] = new int[n];
        int nsr[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i =0;i<n;i++){
            int curr = heights[i];
            while(!s.isEmpty() && heights[s.peek()]>=curr){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        s = new Stack<>();
        for(int i =n-1;i>=0;i--){
            int curr = heights[i];
            while(!s.isEmpty() && heights[s.peek()]>=curr){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = n;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        int max=0;
        for(int i =0;i<n;i++){
           max = Math.max ((nsr[i]-nsl[i]-1)*heights[i],max);
        }
        return max;
    }
}