class Solution {
    public int countSeniors(String[] details) {
        int c=0;
        for(int i =0;i<details.length;i++){
            String t = details[i].substring(11,13);
            if(t.compareTo("60") > 0){
                c++;
            }
        }
        return c;
    }
}