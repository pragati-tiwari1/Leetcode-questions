class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(helper(red,blue), helper(blue,red));
    }
    public int helper(int a,int b){
        int c=0;
        int odd =1;
        int even = 2;
        boolean last = true;
        while(a-odd >=0 || b-even>=0){
            int cnt=0;
            if(a-odd >=0 && last==true){
                c++;
                a-= odd;
                 odd+=2;
                 cnt++;
                last = false;
            }
            if( b-even>=0 && last == false){
            b-=even;
            c++;
            even+=2;
            cnt++;
            last = true;
            }
            if(cnt!=2){
                break;
            }
        }
        return c;
    }
}