class Solution {
    class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    class Info{
        int V;
        int cost;
        int stops;
        Info(int n,int c,int s){
            this.V = n;
            this.cost = c;
            this.stops = s;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst,
     int k) {
        List<List<Edge>> g = new ArrayList<>();
         for(int i =0;i<n;i++){
            g.add( new ArrayList<>());
        }
        for(int i =0;i<flights.length;i++){
            g.get(flights[i][0]).add(new Edge(flights[i][0],flights[i][1],flights[i][2]));
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));
        int d[] = new int[n];
        for(int i =0;i<n;i++){
            d[i] = Integer.MAX_VALUE;
        }
        d[src] = 0;
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops>k){
                break;
            }
            for(int i =0;i<g.get(curr.V).size();i++){
                Edge neigh = g.get(curr.V).get(i);
                if(curr.cost+neigh.wt < d[neigh.dest]){
                    d[neigh.dest] = curr.cost+neigh.wt ;
                    q.add(new Info(neigh.dest,d[neigh.dest],curr.stops+1));
                }
            }
        }
        if(d[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return d[dst];
    }
}