class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(k == 1){
            return true;
        }
        Deque<Integer> q = new LinkedList<>();
        q.add(0);
        HashSet<Integer> set = new HashSet<>();
        for(int i =1;i<k;i++){
            if(nums.get(i-1)< nums.get(i)){
                q.addLast(i);
            }else{
                q.removeLast();
                q.addLast(i);
            }
        }
        if(q.size() == k){
            set.add(0);
        }
        int j =1;
        for(int i =k;i<nums.size();i++){
            while(!q.isEmpty() && q.peekFirst() <= i-k){
                q.removeFirst();
            }
            if(nums.get(i-1)<nums.get(i)){
                q.addLast(i);
            }else{
                q.removeLast();
                q.addLast(i);
            }
            if(q.size() == k){
                set.add(i-k+1);
            }
        }
       // System.out.println(set.size());
        for(int i =0;i<nums.size();i++){
            if(set.contains(i) && set.contains(i+k)){
                return true;
            }
        }
        return false;
    }
}