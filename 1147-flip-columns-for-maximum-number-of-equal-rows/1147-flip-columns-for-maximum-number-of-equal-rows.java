class Solution {
    //taken help
    //maximum possible rows will be that have same pattern, either same or either reversed
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String,Integer> map = new HashMap<>();
        int max = 0;
        for(int i =0;i<matrix.length;i++){
            String s = "";
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][0] == matrix[i][j]){
                    s+='T';
                }else{
                    s+='F';
                }
            }
            map.put(s,map.getOrDefault(s,0)+1);
            max = Math.max(max,map.get(s));
        }
        return max;
    }
}