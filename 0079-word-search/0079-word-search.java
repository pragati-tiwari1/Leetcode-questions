class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean vis[][] = new boolean[board.length][board[0].length];
                    if(helper(board,word,0,vis,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, String word, int idx,boolean vis[][],
    int i,int j){
        if(idx == word.length()){
            return true;
        }
        if(word.charAt(idx)!= board[i][j]){
            return false;
        }
        vis[i][j] = true;
        if(idx == word.length()-1){
            return true;
        }
        if(isSafe(i-1,j,vis,board) && helper(board,word,idx+1,vis,i-1,j)){
            return true;
        }
        else if(isSafe(i+1,j,vis,board) && helper(board,word,idx+1,vis,i+1,j)){
            return true;
        }
        else if(isSafe(i,j-1,vis,board) && helper(board,word,idx+1,vis,i,j-1)){
            return true;
        }
       else if(isSafe(i,j+1,vis,board) && helper(board,word,idx+1,vis,i,j+1)){
            return true;
        }
        vis[i][j] = false;
        return false;
    }
    public boolean isSafe(int i,int j,boolean vis[][], char board[][]){
        if(i<0 ||j<0 ||i>=board.length||j>=board[0].length|| vis[i][j]){
            return false;
        }
        return true;
    }
}