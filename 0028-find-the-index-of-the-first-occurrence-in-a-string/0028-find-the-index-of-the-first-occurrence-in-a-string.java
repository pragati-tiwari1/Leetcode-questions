class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
       return rabinKarp(haystack,needle);  
    }
    public int rabinKarp(String text,String pattern){
        int p = pattern.length();
       double pHash = calculateHash(pattern);
        double thash = calculateHash(text.substring(0,p));
        // System.out.println(pHash);
        for(int i =0;i<=text.length()-p;i++){
            // System.out.println(thash);
            if(thash == pHash){
               // System.out.println("hello");
                if(text.substring(i,i+p).equals(pattern)){
                    return i;
                }
            }
            if(i<text.length()-p){
           thash =  updateHash(thash,text.charAt(i),text.charAt(i+p),p);
            }
        }
        return -1;
    }
    int prime = 101;
    public double calculateHash(String s){
        double hash = 0;
        for(int i =0;i<s.length();i++){
            hash+=s.charAt(i)*Math.pow(prime,i);
        }
        return hash;
    }
    public double updateHash(double prev, char old, char curr, int len){
          double newHash = (prev-old)/prime;
        newHash = newHash + curr * Math.pow(prime,len-1);
        return newHash;
    }
}