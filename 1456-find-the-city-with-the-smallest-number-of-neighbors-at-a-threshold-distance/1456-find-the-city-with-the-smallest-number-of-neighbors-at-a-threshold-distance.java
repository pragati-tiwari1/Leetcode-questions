class Solution {
    public class Edge{
       int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
          this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public class Pair implements Comparable<Pair>{
        int n;
        int path;
        public Pair(int n,int path){
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair  p2){
            return this.path - p2.path;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Edge>> g = new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i =0;i<edges.length;i++){
            int s = edges[i][0];
            int d = edges[i][1];
            int c = edges[i][2];
            g.get(s).add(new Edge(s,d,c));
            g.get(d).add(new Edge(d,s,c));
        }
        int ans[] = new int[n];
        for(int i =0;i<n;i++){
            int dis[] = new int[n];
            find(dis,g,i,n);
            for(int j =0;j<n;j++){
                 if(dis[j] == 0){
                        continue;
                    }
                if(dis[j] <= distanceThreshold){
                    ans[i]++;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int c = 0;
        for(int i =0;i<n;i++){
            // System.out.println(ans[i]);
            if(min > ans[i]){
                min = ans[i];
                c =i;
            }
            if(min == ans[i]){
                c = Math.max(c,i);
            }
        }
        return c;
    }
    //dijkstra
    public void find(int dis[],List<List<Edge>> g,int curr,int n){
        for(int i =0;i<n;i++){
            if(i!= curr){
                dis[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(curr,0));
        boolean vis[] = new boolean[n];
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            if(!vis[p.n]){
                vis[p.n] = true;
                for(int i =0;i<g.get(p.n).size();i++){
                    //int u = p.n;
                    Edge e = g.get(p.n).get(i);
                    int u = e.src;
                    int v = e.dest;
                    int c = e.wt;
                    if(dis[u] + c < dis[v]){
                        dis[v] = dis[u] + c ;
                        pq.add(new Pair(v,dis[v]));
                    }
                }
            }
        }
    }
}