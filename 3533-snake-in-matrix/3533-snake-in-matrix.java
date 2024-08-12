class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int r =0;
        int c =0;
        int ans = 0;
        for(int idx =0;idx<commands.size();idx++){
            if(commands.get(idx).equals("UP")){
                r -=1;
            }
             if(commands.get(idx).equals("DOWN")){
                r+=1;
            }
             if(commands.get(idx).equals("LEFT")){
                c-=1;
            }
             if(commands.get(idx).equals("RIGHT")){
                c+=1;
            }
        }
        return (r*n)+c;
    }
}