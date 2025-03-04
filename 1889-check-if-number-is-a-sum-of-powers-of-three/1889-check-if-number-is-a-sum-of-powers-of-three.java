class Solution {
    public boolean checkPowersOfThree(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(true){
            //System.out.println(n);
            if(n == 2){
                return false;
            }
            if(n == 0 || n == 1 ){
                
                return true;
            }
            int d = count(n);
            if(set.contains(d)){
                return false;
            }
           // System.out.println((int)Math.pow(3,d));
            set.add(d);
            n = n - (int)Math.pow(3,d);

        }
      //  return false;
    }
    public int count(int n){
        int c = 1;
        int a = 3;
        while(n > a){
            a*=3;
            c++;
        }
        if(n == a){
            return c;
        }
        return c-1;
    }
}