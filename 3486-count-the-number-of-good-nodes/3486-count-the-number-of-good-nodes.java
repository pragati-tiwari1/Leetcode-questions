class Solution {

    public int countGoodNodes(int[][] edges) {
       ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i =0;i<=edges.length;i++){
           g.add(new ArrayList<>());
        }
        for(int i =0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            g.get(a).add(b);
            g.get(b).add(a);
        }
        HashSet<Integer> vis = new HashSet<>();
         find(g ,0,vis);
        return ans;
    }
    int ans =0;
    public int find(ArrayList<ArrayList<Integer>> g ,int curr,HashSet<Integer> vis ){
        int c =0;
        vis.add(curr);
        if(g.get(curr).size() == 0){
            ans++;
            return 1;
        }
        int total = 1;
        boolean flag = true;
        for(int i=0;i<g.get(curr).size();i++){
            if(!vis.contains(g.get(curr).get(i))){
            int child = find(g,g.get(curr).get(i),vis);
            if(c!=0 && child != c){
                flag = false;
            }
            c = child;
            total += child;
            }
        }
        if(flag == true ){
            ans++;
        }
        return total;
    }
}