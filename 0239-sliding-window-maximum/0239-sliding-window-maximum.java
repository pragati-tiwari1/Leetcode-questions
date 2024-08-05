class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        int j =0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i =0;i<n;i++){
            if(!q.isEmpty() && i-k == q.peek()){
                q.remove();
            }
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.removeLast();
            }
            q.addLast(i);
            if(i>=k-1){
                ans[j] = nums[q.peek()];
                j++;
            }
        }
        return ans;
    }
}