class Solution {
    public int isPrefixOfWord(String s, String w) {
        int cnt = 0;
        boolean space = true;
        s.trim();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                space = true;
                continue;
            }
            
            if(ch == w.charAt(0)){
                int j =0;
                int k = i;
                while(k < s.length() && j<w.length() ){
                    if(w.charAt(j) != s.charAt(k)){
                        break;
                    }
                    j++;
                    k++;
                }
                if(j == w.length() && space){
                    return cnt+1;
                }
            }
            if(space){
                cnt++;
                space = false;
            }
        }
        return -1;
    }
}