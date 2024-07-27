class Solution {
    class DisjointSet{
        ArrayList<Integer> par = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();
        DisjointSet(int n){
            for(int i =0;i<n;i++){
                par.add(i);
                size.add(0);
            }
        }
        int findPar(int node){
            if(node == par.get(node)){
                return node;
            }
            int p = findPar(par.get(node));
            par.set(node,p);
            return p;
        }
        void unionBySize(int u, int v){
            int parA = findPar(u);
            int parB = findPar(v);
            if(parA == parB){
                return;
            }
            if(size.get(parA)<size.get(parB)){
                par.set(parA,parB);
                 size.set(v,size.get(u)+size.get(v));
            }
            else{
                par.set(parB,parA);
                size.set(u,size.get(u)+size.get(v));
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n  = accounts.size();
        DisjointSet d = new DisjointSet(n);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i =0;i<accounts.size();i++){
            for(int j =1;j<accounts.get(i).size();j++){
                if(!map.containsKey(accounts.get(i).get(j))){
                    map.put(accounts.get(i).get(j),i);
                }else{
                    //  System.out.println(accounts.get(i).get(j));
                    d.unionBySize(i,map.get(accounts.get(i).get(j)));
                }
            }
        }
        ArrayList<String>[] mergeMail = new ArrayList[n];
        for(int i =0;i<n;i++){
            mergeMail[i] = new ArrayList<>();
        }
        for(Map.Entry<String,Integer> it: map.entrySet()){
            String mail = it.getKey();
            int node = d.findPar(it.getValue());
            mergeMail[node].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i =0;i<n;i++){
            if(mergeMail[i].size() == 0){
                continue;
            }
            Collections.sort(mergeMail[i]);
            String name = accounts.get(i).get(0);
            List<String> temp = new ArrayList<>();
            temp.add(name);
            for(String c: mergeMail[i]){
                temp.add(c);
            }
            ans.add(temp);
        }
        return ans;
    }
}