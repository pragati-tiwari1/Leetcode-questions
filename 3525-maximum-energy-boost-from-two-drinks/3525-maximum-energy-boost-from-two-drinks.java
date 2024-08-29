class Solution {
    public long maxEnergyBoost(int[] A, int[] B) {
        int n = A.length;
       // int dp[] = new int[n];
        long a1[] = new long[n];
        long b1[] = new long[n];
       
       a1[0] = A[0];
       b1[0] = B[0];
        for(int i =1;i<n;i++){
            a1[i] = a1[i-1]+A[i];
            b1[i] = b1[i-1]+B[i];
            if(i>1){
            a1[i] = Math.max(a1[i],A[i]+b1[i-2]);
            b1[i] = Math.max(b1[i],B[i]+a1[i-2]);

            }
            
        }
        return Math.max(a1[n-1],b1[n-1]);
    }
}