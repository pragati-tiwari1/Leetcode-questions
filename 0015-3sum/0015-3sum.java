class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int k =0;k<nums.length;k++){
            map = new HashSet<>();
            for(int i =k+1;i<nums.length;i++){
                if(i!=k){
                    if(map.contains(-nums[k]-nums[i])){
                        //voila
                        List<Integer> t = new ArrayList<>();
                        t.add(nums[i]);
                        t.add(-nums[k]-nums[i]);
                        t.add(nums[k]);
                        Collections.sort(t);
                        if(!set.contains(t)){
                            set.add(t);
                        }
                    }
                    map.add(nums[i]);
                }
            }
        }
        for(List<Integer> t:set){
            ans.add(t);
        }
        return ans;
    }
}