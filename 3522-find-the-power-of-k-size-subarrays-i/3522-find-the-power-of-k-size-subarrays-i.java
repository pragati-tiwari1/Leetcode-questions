class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if(k == 1){
            return nums;
        }
        Deque<Integer> q = new LinkedList<>();
        q.add(0);
        int ans[] = new int[nums.length-k+1];
        for(int i =1;i<k;i++){
            if(nums[i-1]+1 == nums[i]){
                q.addLast(i);
            }else{
                q.removeLast();
                q.addLast(i);
            }
        }
        if(q.size() == k){
            ans[0] = nums[q.peekLast()];
        }else{
            ans[0] = -1;
        }
        int j =1;
        for(int i =k;i<nums.length;i++){
            while(!q.isEmpty() && q.peekFirst() <= i-k){
                q.removeFirst();
            }
            if(nums[i-1]+1 == nums[i]){
                q.addLast(i);
            }else{
                q.removeLast();
                q.addLast(i);
            }
            if(q.size() == k){
            ans[j] = nums[q.peekLast()];
            }else{
            ans[j] = -1;
            }
            j++;
        }
        return ans;
    }
}