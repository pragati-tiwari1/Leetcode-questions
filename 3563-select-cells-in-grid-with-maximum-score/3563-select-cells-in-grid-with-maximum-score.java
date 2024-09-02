class Solution {

    private int util(List<Integer>[] maxElePosition,int curMaxEle,int row,boolean vis[],int score){
        if(curMaxEle<=0 || row==0){
            return score;
        }

        while(curMaxEle>=1 &&  maxElePosition[curMaxEle].size()==0){
            curMaxEle--;
        }

        List<Integer>rowsInd = maxElePosition[curMaxEle];
        int max = score;
        boolean found = false;
        for(int i=0;i<rowsInd.size();i++){
            if(!vis[rowsInd.get(i)]){
                vis[rowsInd.get(i)]=true;
                found = true;
                max = Math.max(max,util(maxElePosition,curMaxEle-1,row-1,vis,score+curMaxEle));
                vis[rowsInd.get(i)]=false;
            }
        }

        if(!found){
            max = Math.max(max,util(maxElePosition,curMaxEle-1,row,vis,score));
        }

        return max;
    }

    public int maxScore(List<List<Integer>> grid) {
        List<Integer>[] maxElePosition = new List[101];
        for(int i=0;i<101;i++){
            maxElePosition[i] = new ArrayList<Integer>();
        }

        int max =0;
        int n = grid.size();
        int m = grid.get(0).size();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int val = grid.get(i).get(j);
                max = Math.max(max,val);
                if(!maxElePosition[val].contains(i)){
                    maxElePosition[val].add(i);
                }
            }
        }

        boolean vis[] = new boolean[10];
        return util(maxElePosition,max,n,vis,0);
    }
}