class Solution {
    public int removeStones(int[][] stones) {
        int n  = stones.length;
        if(n<=1){
            return 0;
        }
        List<List<Integer>> g = new ArrayList<>();
        for(int i =0;i<n;i++){
            g.add( new ArrayList<>());
        }
        for(int i =0;i<n;i++){
            int u[] = stones[i];
            for(int j =0;j<n;j++){
                if(i ==j){
                    continue;
                }
                int v[] = stones[j];
                if(u[0] == v[0] || u[1] == v[1]){
                    g.get(i).add(j);
                }
            }
        }
        boolean vis[] = new boolean[n];
        int c =0;
        for(int i =0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,g);
                c++;
            }
        }
        return n - c;
    }
    public void dfs(int curr,boolean vis[],List<List<Integer>> g){
        vis[curr] = true;
        for(int i =0;i<g.get(curr).size();i++){
            int neigh = g.get(curr).get(i);
            if(!vis[neigh]){
                dfs(neigh,vis,g);
            }
        }
    }
}