class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        else{
            String prev = countAndSay(n-1);
            int l = 0;
            int i =0;
            int c=1;
            String ans = "";
            while(i<prev.length()-1){
                if(prev.charAt(i) == prev.charAt(i+1)){
                    c++;
                    i++;
                }
                else{
                    if(c >1){
                        ans+= String.valueOf(c)+prev.charAt(i);
                    }else{
                    ans += String.valueOf(c)+prev.substring(l,i+1);
                    }
                    l = i+1;
                    c=1;
                    i++;
                }
            }
            if(c == 1){
                ans += String.valueOf(c)+prev.substring(l);
            }else{
                ans += String.valueOf(c)+prev.substring(l+1);
            }
           // System.out.println(ans);
            return ans;
        }
    }
}