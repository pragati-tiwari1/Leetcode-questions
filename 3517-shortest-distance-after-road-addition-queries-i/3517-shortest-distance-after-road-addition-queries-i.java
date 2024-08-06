class Solution {
    class Pair implements Comparable<Pair>{
        int n;
        int cost;
        Pair(int n,int cost){
            this.n = n;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2){
          return  this.cost - p2.cost;
        }
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i =0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            g.get(i).add(i+1);
        }
        int ans[] = new int[queries.length];
        for(int i =0;i<queries.length;i++){
            g.get(queries[i][0]).add(queries[i][1]);
            ans[i] = shortestPath(g,0,n);
        }
        return ans;
    }
    public int shortestPath(ArrayList<ArrayList<Integer>> g ,int src,int n){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[n];
        for(int i =0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        pq.add(new Pair(src,0));
        boolean vis[] = new boolean[n];
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            vis[curr.n] = true;
            for(int i=0;i<g.get(curr.n).size();i++){
                int v = g.get(curr.n).get(i);
                if(!vis[v]){
                    if(dist[curr.n]+1 < dist[v]){
                        dist[v] = dist[curr.n]+1;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
            return dist[n-1];
    }
}