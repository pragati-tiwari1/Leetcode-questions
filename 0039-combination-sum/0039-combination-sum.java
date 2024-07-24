class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,candidates,target,new ArrayList<>(),0);
        return ans;
    }
    public void helper(List<List<Integer>> ans,int[] c, int target,
    List<Integer> temp ,int i){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i>= c.length ){
            return;
        }
        if(target >= c[i]){
            temp.add(c[i]);
            helper(ans,c,target-c[i],temp,i);
            temp.remove(temp.size()-1);
        }
        helper(ans,c,target,temp,i+1);
        return;
    }
}