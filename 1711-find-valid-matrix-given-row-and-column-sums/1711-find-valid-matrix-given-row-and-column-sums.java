class Solution {
    //TAKEN HELP FROM HINT
   class Point implements Comparable<Point>{
        int n;
        int idx;
     Point(int n,int idx){
            this.n = n;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point p1){
            return this.n-p1.n;
        }
    }
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        PriorityQueue<Point> row = new PriorityQueue<>();
        PriorityQueue<Point> col = new PriorityQueue<>();
        for(int i =0;i<rowSum.length;i++){
            row.add(new Point(rowSum[i],i));
        }
        for(int i =0;i<colSum.length;i++){
            col.add(new Point(colSum[i],i));
        }
        int m[][] = new int[rowSum.length][colSum.length];
        while(!row.isEmpty() && !col.isEmpty()){
            Point r = row.remove();
            Point c = col.remove();
            if(r.n > c.n){
                m[r.idx][c.idx] = c.n;
                row.add(new Point(r.n-c.n,r.idx));
            }else{
                m[r.idx][c.idx] = r.n;
                col.add(new Point(c.n-r.n,c.idx));
            }
        }
        return m;
    }
}