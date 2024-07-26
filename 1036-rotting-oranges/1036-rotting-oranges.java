class Solution {
    class Pair{
        int row;
        int col;
        int t;
        Pair(int r,int c,int t){
            this.row = r;
            this.col = c;
            this.t = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int cnt=0;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    cnt++;
                }
            }
        }
       
        int ans = 0;
        while(!q.isEmpty()){
            Pair curr = q.remove();
            int r = curr.row;
            int c = curr.col;
            ans = curr.t;
            if(r+1 <grid.length && grid[r+1][c] == 1){
                grid[r+1][c] = 2;
                q.add(new Pair(r+1,c,curr.t+1));
            }
            if(r-1 >=0 && grid[r-1][c] == 1){
                 grid[r-1][c] = 2;
                q.add(new Pair(r-1,c,curr.t+1));
            }
            if(c+1 <grid[0].length && grid[r][c+1] == 1){
                 grid[r][c+1] = 2;
                q.add(new Pair(r,c+1,curr.t+1));
            }
            if(c-1>=0 && grid[r][c-1] == 1){
                 grid[r][c-1] = 2;
                q.add(new Pair(r,c-1,curr.t+1));
            }
        }
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                   return -1;
                }
            }
        }
        return ans;
    }
}