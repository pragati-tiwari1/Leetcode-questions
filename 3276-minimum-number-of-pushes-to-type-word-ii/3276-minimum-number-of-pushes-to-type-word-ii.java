class Solution {
    public int minimumPushes(String word) {
       
        int freq[] = new int[26];
        for(int i =0;i<word.length();i++){
            Character ch = word.charAt(i);
           freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int curr = 1;
        int cnt = 0;
        int ans=0;
        for(int i =25;i>=0;i--){
            if(freq[i] >0){
                ans+= freq[i]*curr;
                cnt++;
                if(cnt == 8){
                    cnt = 0;
                    curr +=1;
                }
            }else{
                break;
            }
        }
        return ans;
    }
}