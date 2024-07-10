class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<ArrayList<String>,Boolean> dp = new HashMap<>();
       return helper(0,"",s,wordDict,dp);
    }
    public boolean helper(int i,String curr,String s, List<String> wordDict
    ,HashMap<ArrayList<String>,Boolean> map ) {
        ArrayList<String> temp = new ArrayList<>();
        temp.add(String.valueOf(i));
        temp.add(curr);
        if(map.containsKey(temp)){
            return map.get(temp);
        }
        if(i== s.length()){
           if(wordDict.contains(curr)){
            return true;
           }else{
            return false;
           }
        }
        boolean inc = false;
        boolean exc = false;
        inc = helper(i+1,curr+s.charAt(i),s,wordDict,map);
        if(wordDict.contains(curr)){
            String t = "";
            t += s.charAt(i);
           exc = helper(i+1,t,s,wordDict,map);
        }

        map.put(temp, inc || exc);
        return inc||exc;
    }
}