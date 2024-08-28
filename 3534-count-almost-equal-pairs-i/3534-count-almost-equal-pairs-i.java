class Solution {

    void swap(char ar[], int i, int j){
        char temp = ar[j];
        ar[j] = ar[i];
        ar[i] = temp;
    }

    boolean same(String a, String b) {
        for(int i=0;i<a.length();i++){
            for(int j=i+1;j<a.length();j++){
                char ar[] = a.toCharArray();
                swap(ar,i,j);
                String cur = new String(ar);
                if(Integer.parseInt(cur)==Integer.parseInt(b)) return true;
                swap(ar,i,j);
            }
        }
        return false;
    }

    boolean check(int x, int y){
        String a = Integer.toString(x);
        String b = Integer.toString(y);
        if(a.equals(b)) return true;
        if(same(a,b)) return true;
        if(same(b,a)) return true;
        return false;
        
    }

    public int countPairs(int[] nums) {
        int n = nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x = nums[i];
                int y = nums[j];
                if(check(x,y)) ans++;
            }
        }
        return ans;
    }
}