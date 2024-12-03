class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder("");
        int last = 0;
        for(int i =0;i<spaces.length;i++){
            ans.append(s.substring(last,spaces[i]) + " ");
            last = spaces[i];
        }
        ans.append(s.substring(last)) ;
        return ans.toString();
    }
}