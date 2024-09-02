class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long t = 0;
        for(int i =0;i<chalk.length;i++){
            t+=chalk[i];
        }
        long a = k%t;
       // k = k%t;
        for(int i =0;i<chalk.length;i++){
            if(chalk[i] <= a){
                a -= chalk[i];
            }
            else{
                return i;
            }
        }
        return 0;
    }
}