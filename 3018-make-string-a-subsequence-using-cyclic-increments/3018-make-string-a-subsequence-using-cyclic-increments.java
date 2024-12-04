class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        //int dp[][] = new int[m+1][n+1];
        if(helper(str1,str2,m,n)==n){
            return true;
        }
        return false;
    }
    public int helper(String str1, String str2, int i, int j){
        if(i == 0|| j == 0){
            return 0;
        }
        
        if(str1.charAt(i-1) == str2.charAt(j-1) || str1.charAt(i-1)-'a'+1 == str2.charAt(j-1)-'a' ||(str1.charAt(i-1)== 'z'&& str2.charAt(j-1)=='a') ){
            return 1+ helper(str1,str2,i-1,j-1); 
        }
           return helper(str1,str2,i-1,j) ;
        
    }
}