class Solution {
    public int getLucky(String s, int k) {
        String temp = "";
        for(int i =0;i<s.length();i++){
            temp+= String.valueOf(s.charAt(i) - 'a' + 1);
        }
        
        while(k!=0){
            temp = helper(temp);
            k--;
        }
        return Integer.valueOf(temp);
    }
    public String helper(String t){
        int val = 0;
        for(int i =0;i<t.length();i++){
            val += t.charAt(i) - '0';
        }
        return String.valueOf(val);
    }
}