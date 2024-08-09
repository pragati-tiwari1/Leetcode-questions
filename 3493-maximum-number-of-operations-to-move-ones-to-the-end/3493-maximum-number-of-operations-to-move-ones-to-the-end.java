class Solution {
    public int maxOperations(String s) {
       // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int zero =0;
        int ans = 0;
        int c=0;
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i) == '1'){
                if(zero>0){
                    zero=0;
                    c++;
                    ans+=c;
                }else{
                    ans+=c;
                }
            }   
            else if(s.charAt(i) == '0'){
                zero++;
            }
        }
        return ans;
    }
}