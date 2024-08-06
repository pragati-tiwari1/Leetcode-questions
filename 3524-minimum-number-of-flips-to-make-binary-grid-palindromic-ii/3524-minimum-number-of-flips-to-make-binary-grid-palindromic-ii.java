class Solution {
    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans=0;
        for(int  i =0;i<m/2;i++){
            for(int j =0;j<n/2;j++){
                int cnt = 0;
                cnt+= grid[i][j];
                cnt+= grid[m-1-i][j];
                cnt+= grid[i][n-1-j];
                cnt+= grid[m-1-i][n-1-j];
                ans += Math.min(cnt,4-cnt);
            }
        }
        int diff = 0;
        int p1 =0;
        //mid row if exists
        if(m%2 == 1){
            for(int j =0;j<n/2;j++){
                if(grid[m/2][j] != grid[m/2][n-j-1]){
                    diff++;
                }else{
                    if(grid[m/2][j] == 1){
                        p1++;
                    } 
                }
            }
        }

        //mid col if exists
        if(n%2 == 1){
            for(int i =0;i<m/2;i++){
                if(grid[i][n/2] != grid[m-1-i][n/2]){
                    diff++;
                }else{
                    if(grid[i][n/2] == 1){
                        p1++;
                    } 
                }
            }
        }

        if(m%2 == 1 && n%2 == 1){
            if(grid[m/2][n/2] == 1){
                ans+=1;
            }
        }
        int ans1 = 0;
        if(diff%2 == p1%2){
            ans1 = diff;
        }else {
        if(diff%2==0){
            if(diff == 0){
                ans1+=2;
            }else{
                ans1 = diff;
            }
        }
        else{
            ans1 = diff;
        }
        }
        return ans+ans1;
    }
}