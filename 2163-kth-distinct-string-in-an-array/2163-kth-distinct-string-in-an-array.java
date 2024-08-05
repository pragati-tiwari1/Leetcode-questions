class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            String curr = arr[i];
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        for(int i =0;i<arr.length;i++){
            String curr = arr[i];
            if(map.get(curr) == 1){
                k--;
                if(k==0){
                    return curr;
                }
            }
        }
        return "";
    }
}