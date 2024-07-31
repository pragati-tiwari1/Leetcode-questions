class Solution {
    public int minAddToMakeValid(String s) {
        int c =0;
        int open = 0;
        for(int i =0;i<s.length();i++){
            Character ch = s.charAt(i);
            if(ch == '('){
                open++;
            }
            else if(ch == ')'){
                if(open > 0){
                    open--;
                }else{
                    c++;
                }
            }
        }
         return c+open;
    }
}