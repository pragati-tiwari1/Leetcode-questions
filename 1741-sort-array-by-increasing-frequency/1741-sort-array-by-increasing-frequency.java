class Solution {
    class Point implements Comparable<Point>{
        int n;
        int freq;
        Point(int n,int freq){
            this.n = n;
            this.freq = freq;
        }
        @Override
        public int compareTo(Point p2){
            if(this.freq == p2.freq){
                return  p2.n - this.n ;
            }
            return this.freq - p2.freq;
        }
    }
    public int[] frequencySort(int[] nums) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int n: map.keySet()){
            pq.add(new Point(n,map.get(n)));
        }
        int i =0;
        while(!pq.isEmpty()){
            int n = pq.peek().n;
            int freq = pq.remove().freq;
            while(freq!=0){
                nums[i] = n;
                freq--;
                i++;
            }
        }
        return nums;
    }
}