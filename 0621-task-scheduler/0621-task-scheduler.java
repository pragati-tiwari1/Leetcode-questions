class Solution {
   
    public int leastInterval(char[] tasks, int n) {
       int max = 0;
        int freq[] = new int[26];
        for(int i =0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
            max = Math.max(max,freq[tasks[i]-'A']);
        }
        int maxCount = 0;
        for(int i =0;i<26;i++){
           if(max == freq[i]){
            maxCount++;
           }
        }
        int a = (max-1)*(n+1)+maxCount;
        int b = tasks.length;
        return Math.max(a,b);
        
    }
}