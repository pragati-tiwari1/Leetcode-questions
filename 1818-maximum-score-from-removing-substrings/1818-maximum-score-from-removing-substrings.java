class Solution {
    public int maximumGain(String s, int x, int y) {
        int ans = 0;
        Stack<Character> st = new Stack<>();
        if(x>y){
           for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && ch =='b' && st.peek() == 'a'){
                st.pop();
                ans+=x;
            }
            else{
                st.push(ch);
            }
           }
           String temp="";
           while(!st.isEmpty()){
            temp=st.pop()+temp;
           }
           for(int i =0;i<temp.length();i++){
            char ch = temp.charAt(i);
            if(!st.isEmpty() && ch =='a' && st.peek() == 'b'){
                st.pop();
                ans+=y;
            }
            else{
                st.push(ch);
            }
           }
           return ans;
        }

        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && ch =='a' && st.peek() == 'b'){
                st.pop();
                ans+=y;
            }
            else{
                st.push(ch);
            }
           }
           String temp="";
           while(!st.isEmpty()){
            temp=st.pop()+temp;
           }
           for(int i =0;i<temp.length();i++){
            char ch = temp.charAt(i);
            if(!st.isEmpty() && ch =='b' && st.peek() == 'a'){
                st.pop();
                ans+=x;
            }
            else{
                st.push(ch);
            }
           }
           return ans;
    }
}