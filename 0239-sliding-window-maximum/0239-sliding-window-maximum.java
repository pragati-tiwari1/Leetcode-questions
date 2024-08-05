class Solution {
    class Info implements Comparable<Info>{
        int n;
        int idx;
        Info(int n,int idx){
            this.n = n;
            this.idx = idx;
        }
        @Override
        public int compareTo(Info i2){
            return i2.n-this.n;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int n = nums.length;
        int ans[] = new int[n-k+1];
        for(int i=0;i<k;i++){
            pq.add(new Info(nums[i],i));
        }
        ans[0] = pq.peek().n;
        for(int i=k;i<n;i++){
            pq.add(new Info(nums[i],i));
            while(!pq.isEmpty() && pq.peek().idx <= i-k){
                pq.remove();
            }
            ans[i-k+1] = pq.peek().n;
        }
        return ans;
    }
}