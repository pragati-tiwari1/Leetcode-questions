class Solution {
    class Point implements Comparable<Point>{
        int r;
        int c;
        int cnt;
        Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Point p2){
            return this.cnt - p2.cnt;
        }
    }
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,-1,1};
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        if(grid[0][0] == 0){
            pq.add(new Point(0,0,0));
        }else{
            pq.add(new Point(0,0,1));
        }
        while(!pq.isEmpty()){
            Point curr = pq.remove();
            if(curr.r == grid.length-1 && curr.c == grid[0].length-1){
                return curr.cnt;
            }
            for(int i =0;i<4;i++){
                int x = dx[i]+curr.r;
                int y = dy[i]+curr.c;
                if(isValid(x,y,grid)){
                    pq.add(new Point(x,y,curr.cnt+grid[x][y]));
                    grid[x][y] = 2;
                }
            }
        }
        return 0;
    }
    public boolean isValid(int x, int y, int[][] grid){
        if(x<0 || y<0 || x>= grid.length || y >= grid[0].length || grid[x][y] == 2){
            return false;
        }
        return true;
    }
}