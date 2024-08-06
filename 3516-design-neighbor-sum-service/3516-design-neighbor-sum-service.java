class neighborSum {
    HashMap<Integer,int[]> map; 
    int g[][] ;
    public neighborSum(int[][] grid) {
        map = new HashMap<>();
        g = grid;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                map.put(grid[i][j],new int[]{i,j});
            }
        }
    }
    
    public int adjacentSum(int value) {
        int pos[] = map.get(value);
        int x = pos[0];
        int y = pos[1];
        int ans =0;
        if(y-1>=0){
          ans+=  g[x][y-1];
        }
        if(y+1 < g[0].length){
            ans+=g[x][y+1];
        }
        if(x-1 >=0 ){
            ans += g[x-1][y];
        }
        if(x+1 < g.length){
            ans+= g[x+1][y];
        }
        return ans;
    }
    
    public int diagonalSum(int value) {
        int pos[] = map.get(value);
        int x = pos[0];
        int y = pos[1];
        int ans =0;
        if(y-1 >=0 && x-1 >=0){
          ans+=  g[x-1][y-1];
        }
        if(y+1 < g[0].length && x+1 < g.length){
            ans+=g[x+1][y+1];
        }
        if(x+1 < g.length &&  y-1 >=0){
            ans += g[x+1][y-1];
        }
        if(x-1 >=0 && y+1 < g[0].length){
            ans+= g[x-1][y+1];
        }
        return ans;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */