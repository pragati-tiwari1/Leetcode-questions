class Solution {
    public int maximumLength(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        int max=0;
        for(int i=0;i<s.length();i++){
            for(int j =i;j<s.length();j++){
                if(s.charAt(i)!= s.charAt(j)){
                    break;
                }
                map.put(s.substring(i,j+1),map.getOrDefault(s.substring(i,j+1),0)+1);
                int val = map.get(s.substring(i,j+1));
                if(val >= 3){
                    max = Math.max(j-i+1,max);
                }
            }
        }
        if(max == 0){
            return -1;
        }
        return max;
    }
}