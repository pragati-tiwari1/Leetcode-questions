class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int c=0;
        for(int i = 0;i<=grid.length-3;i++){
            for(int j =0;j<=grid[0].length-3;j++){
                if(isSame(i,j,grid)){
                    c++;
                }
            }
        }
        return c;
    }
    public boolean isSame(int r,int c,int grid[][]){
        HashSet<Integer> set = new HashSet<>();
        for(int i =r;i<r+3;i++){
            for(int j =c;j<c+3;j++){
                if(grid[i][j] >9 || grid[i][j] < 1){
                    return false;
                }else{
                    if(set.contains(grid[i][j])){
                        return false;
                    }
                    set.add(grid[i][j]);
                }
            }
        }

        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        
        //row
        for(int i =r;i<r+3;i++){
            int t=0;
            for(int j =c;j<c+3;j++){
                t+=grid[i][j];
            }
           
            if(t!=sum){
                return false;
            }
        }

        //col
        for(int j =c;j<c+3;j++){
            int t=0;
            for(int i =r;i<r+3;i++){
                t+=grid[i][j];
            }
            
            if(t!=sum){
                return false;
            }
        }

        //diagonal
        int t=0;
        for(int i =r,j=c;i<r+3 && j<c+3;i++,j++){
            t+=grid[i][j];
        }
        if(t!=sum){
                return false;
         }
        t= 0;
         for(int i =r,j=c+3-1;i<r+3 && j>=0;i++,j--){
            t+=grid[i][j];
        }
        
        if(t!=sum){
                return false;
         }
         return true;
    }
}