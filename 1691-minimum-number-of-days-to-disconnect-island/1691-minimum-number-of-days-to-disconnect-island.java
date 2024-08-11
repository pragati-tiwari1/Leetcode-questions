class Solution {
    public int minDays(int[][] grid) {
        if(grid.length == 1 && grid[0].length == 1 && grid[0][0] == 1){
            return 1;
        }
        if(grid.length == 1 && grid[0].length == 2){
            int a = grid[0][1];
             a += grid[0][0];
             return a;
        }
        if(grid.length == 2 && grid[0].length == 1){
            int a = grid[1][0];
             a += grid[0][0];
             return a;
        }
        int c=0;
        if(isNotSingle(grid)){
            return 0;
        }
        if(grid.length == 1 || grid[0].length == 1 ){
            return 1;
        }
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    System.out.print(i+" ");
        System.out.print(j+" ");
                    if(isNotSingle(grid)){
                        
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
    return 2;
    }
    public boolean isNotSingle(int [][]grid){
        int cnt=0;
        boolean vis[][] = new boolean[grid.length][grid[0].length];
       for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    dfs(i,j,grid,vis);
                    cnt++;
                }
            }
        }
       // System.out.println(cnt);
        if(cnt==1){
            return false;
        }
        return true;
    }
    public void dfs(int r,int c,int [][]grid, boolean vis[][] ){
        vis[r][c] = true;
        if(isValid(r-1,c,grid,vis)){
            dfs(r-1,c,grid,vis);
        }
        if(isValid(r,c-1,grid,vis)){
            dfs(r,c-1,grid,vis);

        }
        if(isValid(r+1,c,grid,vis)){
            dfs(r+1,c,grid,vis);

        }
        if(isValid(r,c+1,grid,vis)){
            dfs(r,c+1,grid,vis);
        }
    }
    public boolean isValid(int i,int j, int[][] grid, boolean vis[][] ){
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && !vis[i][j] && grid[i][j] ==1){
            return true;
        }
        return false;
    }
}