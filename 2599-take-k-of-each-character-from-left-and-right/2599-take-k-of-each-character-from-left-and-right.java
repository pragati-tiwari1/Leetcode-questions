class Solution {
    //TAKEN HELP
    public int takeCharacters(String s, int k) {
        if(3*k > s.length()){
            return -1;
        }
        int freq[] = new int[3];
        for(int i =0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        if(Math.min(freq[0],Math.min(freq[1],freq[2])) < k){
            return -1;
        }
        int l =0;
        int ans = Integer.MAX_VALUE;
        for(int r = 0;r<s.length();r++){
            freq[s.charAt(r)-'a']--;//we will try to see if by decreasing freq will it hamper the case, of all the char to be >= k
            //if by decraesing this causes issue we will increase from left, as we have to find the window from left to right which we can remove , so that
            // the remaining elements togetherly can become minimum steps 
            while(Math.min(freq[0],Math.min(freq[1],freq[2])) < k){
                freq[s.charAt(l)-'a']++;
                l++;
            }
            ans = Math.min(ans,s.length()-(r-l+1));
        }
        return ans;
    }
}