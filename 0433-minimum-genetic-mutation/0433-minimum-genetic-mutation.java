class Solution {
    public int minMutation(String s, String e, String[] bank) {
        boolean vis[] = new boolean[bank.length];
        int cnt = helper(s,e,bank,0,vis) ;
            if(cnt != Integer.MAX_VALUE){
            return cnt;
            }
        return -1;
    }
   // int cnt=Integer.MAX_VALUE;
    public int helper(String s, String e, String[] bank, int t,boolean vis[]){
      
        if(s.equals(e)){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i =0;i<bank.length;i++){
            if(!vis[i]){
            String b=bank[i];
            int c=0;
            for(int j =0;j<b.length();j++){
                if(b.charAt(j) != s.charAt(j)){
                    c++;
                }
            }
            if(c == 1){
                vis[i] = true;
                ans = Math.min(ans,helper(b,e,bank,t+1,vis));
                vis[i] = false;
            }
            }
        }
        if(ans == Integer.MAX_VALUE){ 
            return ans;
        }
        return ans+1;
    }
    public boolean isEqual(String s, String e){
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)!= e.charAt(i)){
                return false;
            }
        }
        return true;
    }
}