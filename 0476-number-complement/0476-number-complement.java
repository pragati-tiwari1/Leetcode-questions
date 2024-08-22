class Solution {
    public int findComplement(int num) {
        if(num == 0){
            return 1;
        }
        int bitlength = Integer.toBinaryString(num).length();
        int mask = (1<<bitlength)-1;
        return mask^num;
    }
    //(1<<bitlength) -> it will shift the 1 by the the bitlength, suppose length is 
    // 3 so, 1 is shifted by 3 as 1000(8), now by substracting 1 (8-1=7) we can get all 3 one's as 111.
}