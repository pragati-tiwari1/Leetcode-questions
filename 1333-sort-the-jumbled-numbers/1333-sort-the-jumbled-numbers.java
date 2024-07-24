class Solution {
    class Info implements Comparable<Info>{
        int n1;//original
        int n2;//new formed
        int idx;
        Info(int n1,int n2,int idx){
            this.n1 = n1;
            this.n2 = n2;
            this.idx = idx;
        }
        @Override
        public int compareTo(Info i2){
            if(this.n2 == i2.n2){
                return this.idx - i2.idx;
            }
            return this.n2 - i2.n2;
        }
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i =0;i<nums.length;i++){
            int transformed = helper(mapping, nums[i]);
            System.out.println(transformed);
            pq.add(new Info(nums[i],transformed,i));
        }
         for(int i =0;i<nums.length;i++){
            nums[i] = pq.remove().n1;
        }
        return nums;
    }
    public int helper(int[] mapping, int num){
        int c = 0;
        int mul = 1;
        if(num == 0){
            return mapping[0];
        }
        while(num!=0){
            int r = num%10;

            c += mapping[r]*mul;
            mul = mul*10;
            num = num/10;
        }
        return c;
    }
}