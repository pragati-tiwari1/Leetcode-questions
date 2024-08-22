class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        
        ArrayList<ArrayList<Integer>> g1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> g2 = new ArrayList<>();
        init(g1,edges1);
        init(g2,edges2);
        int res[] = new int[1];
         dfs(0,-1,g1,res);
         int d1 = res[0];
        res[0]= 0;
        dfs(0,-1,g2,res);
        int d2 = res[0];
        //System.out.println(d2);
        return Math.max(Math.max(d1-1,d2-1),d1/2 +d2/2 +1);
    }
    public void init(ArrayList<ArrayList<Integer>> g, int[][] edges){
        for(int i =0;i<=edges.length;i++){
            g.add(new ArrayList<>());
        }
        for(int i =0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            g.get(a).add(b);
            g.get(b).add(a);
        }
    }

    public int dfs(int node, int par,ArrayList<ArrayList<Integer>> g,
    int res[]){
        int maxDepth = 1;
        for(Integer neigh : g.get(node)){
            if(neigh == par)
                continue;
            
            int depth = dfs(neigh,node,g,res);
            res[0] = Math.max(res[0],maxDepth+depth);
            maxDepth = Math.max(maxDepth,depth+1);
        }
        return maxDepth;
    }
}