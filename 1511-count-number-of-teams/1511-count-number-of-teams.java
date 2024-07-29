class Solution {
    public int numTeams(int[] rating) {
        int c=0;
        for(int i =0;i<rating.length;i++){
            c+=count(rating[i],rating.length,rating,i);
        }
        return c;
    }
    public int count(int curr,int n,int[] rating,int idx){
        int left[] =countGreaterOrSmaller(rating,0,idx,curr);
        int right[] =countGreaterOrSmaller(rating,idx+1,n,curr);

        int teams = 0;
        teams += left[0]*right[1];//ascending
        teams += left[1]*right[0];//descending
        return teams;
    }
    public int[] countGreaterOrSmaller(int rating[],int s,int e,int curr){
       int small=0;
       int large=0;
        for(int i =s;i<e;i++){
            if(rating[i]<curr){
                small++;
            }else{
                large++;
            }
        }
        return new int[]{small,large};
    }
}