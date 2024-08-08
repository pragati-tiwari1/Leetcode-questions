class Solution {
    public int nonSpecialCount(int l, int r) {
        int limit = (int)Math.sqrt(r)+1;

        boolean isPrime[] = new boolean[limit+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i =2;i*i<=limit;i++){
            if(isPrime[i]){
                for(int j = i*i;j<=limit;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        int sp = 0;
        for(int i =2;i<=limit;i++){
            if(isPrime[i]){
                if(i*i>=l && i*i<=r){
                    sp++;
                }
            }
        }
        int total = r-l+1;
        return total-sp;
    }
}