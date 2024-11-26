class Solution {
    public int findChampion(int n, int[][] edges) {
        int in[] = new int[n];
        for(int i =0;i<edges.length;i++){
            in[edges[i][1]]++;
        }
        boolean flag = false;
        int ans = 0;
        for(int i =0;i<n;i++){
            if(in[i] == 0 ){
                if(!flag){
                    flag = true;
                    ans = i;
                }else{
                    flag = false;
                    break;

                }
            }
        }
        if(!flag){
            return -1;
        }
        return ans;
    }
}