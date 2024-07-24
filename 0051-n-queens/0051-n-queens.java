class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList<>();
        boolean matrix[][] = new boolean[n][n];
        helper(board,matrix,n,0);
        return board;
    }
    public void helper(List<List<String>> board, boolean matrix[][] ,int n, int r){
        if(r == n){
           List<String> t = new ArrayList<>();
           for(int i =0;i<n;i++){
            String curr = "";
            for(int j=0;j<n;j++){
                if(matrix[i][j]){
                    curr+='Q';
                }else{
                    curr+='.';
                }
            }
            t.add(curr);
           }
           board.add(new ArrayList<>(t));
           return ;
        }
        for(int c =0;c<n;c++){
            if(isSafe(r,c,matrix)){
                matrix[r][c] = true;
                helper(board,matrix,n,r+1);
                matrix[r][c] = false;
            }
        }
        return ;
    }
    public boolean isSafe(int r,int c, boolean matrix[][]){
        for(int i =0;i<r;i++){
            if(matrix[i][c]){
                return false;
            }
        }
        for(int i =0;i<c;i++){
            if(matrix[r][i]){
                return false;
            }
        }
        for(int i = r-1,j=c-1;i>=0&&j>=0;i--,j--){
            if(matrix[i][j]){
                return false;
            }
        }
        for(int i = r-1,j=c+1;i>=0&&j<matrix.length;i--,j++){
            if(matrix[i][j]){
                return false;
            }
        }
        return true;
    }
}