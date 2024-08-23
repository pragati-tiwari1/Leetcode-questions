class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int X[] = new int[grid[0].length];
        int Y[] = new int[grid[0].length];
        Arrays.fill(X,0);
        Arrays.fill(Y,0);
        int c=0;
        for(int i =0;i<m;i++){
            int x=0,y=0;
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 'X'){
                    x++;
                }
                if(grid[i][j] == 'Y'){
                    y++;
                }
                X[j] += x;
                Y[j] += y;
                if(X[j] > 0 && X[j] == Y[j]){
                    c++;
                }
            }
        }
        return c;
    }
}