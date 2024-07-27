class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> c) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i =0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i =0;i<c.size();i++){
            int a = c.get(i).get(0);
            int b = c.get(i).get(1);
         //   System.out.println(a);
            g.get(a).add(b);
            g.get(b).add(a);
        }
        int dt[] = new int[n];
        int low[] = new int[n];
        boolean vis[] = new boolean[n];
        int time = 0;
        List<List<Integer>> ans= new ArrayList<>();
        for(int i =0;i<n;i++){
            if(!vis[i]){
                bridge(g,i,-1,dt,low,vis,time,ans);
            }
        }
        return ans;
    }
    public void bridge(List<List<Integer>> graph,int curr,int par,int dt[], int low[],
    boolean vis[],int time, List<List<Integer>> ans){
        vis[curr] = true;
        dt[curr] = time+1;
        low[curr] = time+1;
        time+=1;
        for(int i =0;i<graph.get(curr).size();i++){
            int neigh = graph.get(curr).get(i);
            if(neigh == par){
                continue;
            }
            else if(!vis[neigh]){
                bridge(graph,neigh,curr,dt,low,vis,time,ans);
                low[curr] = Math.min(low[curr],low[neigh]);
                if(dt[curr]<low[neigh]){
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(curr);
                    t.add(neigh);
                    ans.add(t);
                }
            }else{
                low[curr] = Math.min(low[curr],dt[neigh]);
            }
        }

    }
}