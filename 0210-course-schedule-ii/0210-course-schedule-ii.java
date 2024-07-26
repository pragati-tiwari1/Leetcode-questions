class Solution {
    public int[] findOrder(int numCourses, int[][] p) {
        int ans[] = new int[numCourses];
        int in[] = new int[numCourses];
        List<List<Integer>> g = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            g.add(new ArrayList<>());
        }
        for(int i =0;i<p.length;i++){
            int a = p[i][0];
            int b = p[i][1];
            g.get(b).add(a);
            in[a]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i =0;i<in.length;i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        if(q.isEmpty()){
            return new int[0];
        }
        int i=0;
        while(!q.isEmpty()){
            int curr = q.remove();
            ans[i] = curr;
            i++;
            for(int j =0;j<g.get(curr).size();j++){
                int n = g.get(curr).get(j);
                in[n]--;
                if(in[n] == 0){
                    q.add(n);
                }
            }
        }
        
        if(i == numCourses){
            return ans;
        }
        return new int[0];
    }
}