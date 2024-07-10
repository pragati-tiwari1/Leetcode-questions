class Solution {
    public int minOperations(String[] logs) {
        Stack<String> s= new Stack<>();
        for(int i =0;i<logs.length;i++){
            String curr = logs[i];
            if(curr.charAt(0) == '.'){
                if(curr.charAt(1) == '.'){
                    if(!s.isEmpty()){
                        s.pop();
                    }
                }
            }else{
                s.push(curr);
            }
        }
        return s.size();
    }
}