class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int c =0;
        for(int i =0;i<grid2.length;i++){
            for(int j =0;j<grid2[0].length;j++){
                if(grid2[i][j] == 1){
                    dfs(grid2,i,j,1,2);
                    if(check(grid1,grid2,i,j)){
                        // System.out.println(i+" "+j);
                        c++;
                    }
                    dfs(grid2,i,j,2,3);
                }
            }
        }
        return c;
    }
    int []dx = {1,-1,0,0};
    int []dy = {0,0,-1,1};

    public void dfs(int[][] grid2, int r ,int c,int old, int val){
      grid2[r][c] = val;
      for(int i =0;i<4;i++){
        int r1 = r+dx[i];
        int c1 = c+dy[i];
        if(c1 >=0 && c1 < grid2[0].length && r1 >=0 && r1< grid2.length && grid2[r1][c1] == old){
            dfs(grid2,r1,c1,old,val);
        }
      }
    }
    public boolean check(int[][] grid1, int[][] grid2, int r, int c){
    // System.out.println(r+" "+c);
        grid2[r][c] = 3;
       if(grid1[r][c] == 0){
        return false;
       }
       for(int i =0;i<4;i++){
        int r1 = r+dx[i];
        int c1 = c+dy[i];
        if(c1 >=0 && c1 < grid2[0].length && r1 >=0 && r1< grid2.length && grid2[r1][c1] == 2){
            if(!check(grid1,grid2,r1,c1)){
                return false;
            }
        }
      }
      return true;
    }
}