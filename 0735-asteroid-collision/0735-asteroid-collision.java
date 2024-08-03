class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> s = new Stack<>();
        for(int i =0;i<a.length;i++){
            int curr = a[i];
            int f=0;
            while(!s.isEmpty() &&  (s.peek()>0 && curr<0)){
               int ai = Math.abs(s.peek());
               int b = Math.abs(curr);
               if(ai == b){
                 s.pop();
                 f=1;
                break;
               }
              else if(ai>b){
                f=1;
                break;
               }
               else{
                s.pop();
               }
            }
            if(f!=1){
                  s.push(curr);
            }
        }
        if(s.isEmpty()){
            return new int[]{};
        }
        int ans[] = new int[s.size()];
       int i = s.size()-1;
       while(!s.isEmpty()){
        ans[i] = s.pop();
        i--;
       }
       return ans;
    }
}