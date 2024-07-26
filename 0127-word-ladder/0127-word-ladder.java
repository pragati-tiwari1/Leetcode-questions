class Solution {
    class Pair{
        String str;
        int lvl;
        Pair(String s, int l){
            this.str = s;
            this.lvl = l;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(int i =0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair curr = q.remove();
            String s = curr.str;
            if(s.equals(endWord)){
                return curr.lvl;
            }
            for(int i=0;i<s.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char a[] = s.toCharArray();
                    a[i]= ch;
                    String t = new String(a);
                    if(set.contains(t)){
                        q.add(new Pair(t,curr.lvl+1));
                        set.remove(t);
                    }
                }
            }
        }
         return 0;
    }
}