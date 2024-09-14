class Solution {
    class Point implements Comparable <Point>{
        int val;
        int c;
        Point(int val, int c){
            this.val = val;
            this.c = c;
        }
        @Override
        public int compareTo(Point p2){
            if(this.c == p2.c){
                return p2.val - this.val;
            }
            return this.c - p2.c;
        }
    }
    public int snakesAndLadders(int[][] board) {
        HashMap<Integer,int[]> map = new HashMap<>();
        HashSet<Integer> vis = new HashSet<>();
        int flag = 0;
        int n = board.length;
        int t = 1;
        boolean inc = true;
        for(int i =n-1;i>=0;i--){
            for(int j =0;j<n;j++){
               if(board[i][j] != -1){
                flag=1;
               }
                map.put(t,new int[]{i,j});
                if(j != n-1){
                if(inc){
                    t++;
                }else{
                    t--;
                }
                }
            }
            if(inc){
                inc = false;
            }else{
                inc = true;
            }
            t = t+n;
        }
        if(flag == 0){
            return ((n*n)/6) +1;
        }
        System.out.println(n*n);
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(1,0));
        int cnt = 0;
        while(!q.isEmpty()){
            Point curr = q.remove();
            cnt++;
            vis.add(curr.val);
            if(curr.val == n*n){
               // System.out.println(cnt);
                return curr.c;
            }
            if(cnt > 1000000){
                break;
            }
            for(int i = curr.val+1;i<=Math.min(n*n,curr.val+6);i++){
                int temp[] = map.get(i);
               // System.out.println(i);
                if( !vis.contains(i) && board[temp[0]][temp[1]] == -1 ){
                    //System.out.println(i);
                    q.add(new Point(i,curr.c+1));
                }else if( !vis.contains(board[temp[0]][temp[1]]) && board[temp[0]][temp[1]] != -1){
                    //System.out.println(board[temp[0]][temp[1]]);
                    q.add(new Point(board[temp[0]][temp[1]],curr.c+1));
                }
                
            }
        }
        return -1;
    }
}