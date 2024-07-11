class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String ans ="";
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == ')'){
                String temp = "";
                while(!st.isEmpty()){
                    if(st.peek() == '('){
                        st.pop();
                        break;
                    }
                    temp+=st.pop();
                } 
                if(!st.isEmpty()){
                    int idx =0;
                    while(idx<temp.length()){
                        st.push(temp.charAt(idx));
                        idx++;
                    }
                }else{
                    ans+=temp;
                }
            }else{
                if(s.charAt(i) =='('){
                    st.push(s.charAt(i));
                }
                else if(st.size()>0){
                    st.push(s.charAt(i));
                }
                else{
                    ans+=s.charAt(i);
                }
            }

        }
        return ans;
    }
}