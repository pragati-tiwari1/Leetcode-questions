class Solution {
    class Info implements Comparable<Info>{
        int n;
        int idx;
        Info(int n, int idx){
            this.n = n;
            this.idx = idx;
        }
        @Override
        public int compareTo(Info i2){
            if(this.n == i2.n){
                return this.idx - i2.idx;
            }
            return this.n - i2.n;
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(new Info(nums[i],i));
        }
        while(k!=0){
            Info c = pq.remove();
            pq.add(new Info(c.n*multiplier,c.idx));
            k--;
        }
        while(!pq.isEmpty()){
            Info c = pq.remove();
            nums[c.idx] = c.n;
        }
        return nums;
    }
}