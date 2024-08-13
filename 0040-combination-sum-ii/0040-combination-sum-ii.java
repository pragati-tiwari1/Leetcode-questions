class Solution {
    List<List<Integer>> ans ;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
      helper(candidates,target,temp,0); 
      return ans;
    }
    public void helper(int[] candidates, int target,List<Integer> temp,int idx){
        
        if(target == 0){
                ans.add(new ArrayList<>(temp));
            return;
        }
        else if(target > 0){
             for(int i = idx;i<candidates.length;i++){//for removing duplicates
           if(i>idx && candidates[i] == candidates[i-1]){
               continue;
           }
           if(candidates[i] > target){
               break;
           }
           temp.add(candidates[i]);
           helper(candidates,target-candidates[i],temp,i+1);
           temp.remove(temp.size()-1);
       }
        }
      
    }
}