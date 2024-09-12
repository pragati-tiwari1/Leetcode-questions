class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int ans =0;
        for(int i=0;i<tokens.length;i++){
            String curr = tokens[i];
            if(curr.equals("+") || curr.equals("*") ||
             curr.equals("-") || curr.equals("/") ){
                int b = s.pop();
                int a  = s.pop();
                if(curr.equals("+")){
                    s.push(a+b);
                }
                if(curr.equals("-")){
                    s.push(a-b);
                }
                if(curr.equals("*")){
                    s.push(a*b);
                }
                if(curr.equals("/")){
                    s.push(a/b);
                }
             }else{
                s.push(Integer.valueOf(curr));
             }
        }
        return s.pop();
    }
}