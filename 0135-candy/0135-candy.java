class Solution {
    //TAKEN HELP
    public int candy(int[] ratings) {
        int cost[] = new int[ratings.length];
        Arrays.fill(cost,1);
        for(int i =1;i<ratings.length;i++){
           if(ratings[i]>ratings[i-1]){
            cost[i] = cost[i-1]+1;
           }
        }
        for(int i =ratings.length-2;i>=0;i--){
           if(ratings[i]>ratings[i+1]){
            cost[i] = Math.max(cost[i],cost[i+1]+1);
           }
        }
        int c=0;
        for(int i =0;i<cost.length;i++){
           System.out.println(cost[i]);
            c+=cost[i];
        }
        return c;
    }
}