class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int dist[] = new int[n];
     HashMap<Integer,Integer> map = new HashMap<>();
     for(int i =0;i<n-1;i++){
        map.put(i,i+1);
     }   
     int ans[] = new int[queries.length];
     int c=0;
     for(int i =0;i<queries.length;i++){
        int a = queries[i][0];
        int b = queries[i][1];
      
       if(map.containsKey(a) && b > map.get(a)){
        int j = a;
        while(j<b){
            j = map.remove(j);
        }
        map.put(a,b);
       }
       ans[c] = map.size();
        c++;
     }
     return ans;
    
    }
}