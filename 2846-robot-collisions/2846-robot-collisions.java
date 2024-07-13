class Solution {
    public List<Integer> survivedRobotsHealths(int[] pos, int[] healths, String dir) {
        HashMap<Integer,Character> d = new HashMap<>();
        HashMap<Integer,Integer> h = new HashMap<>();
        HashMap<Integer,Integer> idx = new HashMap<>();

        for(int i =0;i<pos.length;i++){
            int curr = pos[i];
            d.put(curr,dir.charAt(i));
            h.put(curr,healths[i]);
            idx.put(curr,i);
        }
        Arrays.sort(pos);
        Stack<Integer> s = new Stack<>();
        for(int i =0;i<pos.length;i++){
            int curr = pos[i];
            char ch = d.get(curr);
            // System.out.print(h.get(curr));
            // System.out.print(ch);
           

            boolean f = false;
            if(!s.isEmpty() && d.get(s.peek()) == 'R' && ch == 'L'){//voila
               while(!s.isEmpty() && d.get(s.peek()) == 'R' && ch == 'L'){
                
               if(h.get(s.peek()) > h.get(curr)){
                 int prev = h.get(s.peek());
                 h.put(s.peek(),prev-1);
                 f = false;
                //   System.out.print(" "+prev);
                //     System.out.print(" "+h.get(curr));
                 break;
                }
                else if(h.get(s.peek()) < h.get(curr)){
                  int r =  s.pop();
                    f = true;
                   int prev =  h.get(curr);
                    // System.out.print(" "+prev);
                    // System.out.print(" "+h.get(r));

                    h.put(curr,prev-1);
                }
                else{
                  int r =  s.pop();
                    f = false;
                    //  System.out.print("Dono "+h.get(curr));
                    // System.out.print(" "+h.get(r));
                    break;
                }
               }  
               if(f && h.get(curr) > 0){
                s.push(curr);
                }
            }
            else{
                s.push(curr);
            }
                    System.out.println();
        }
        ArrayList<Integer> ans = new ArrayList<>();
         for(int i =0;i<pos.length;i++){
            ans.add(-1);
        }
        while(!s.isEmpty()) {
           int i = idx.get(s.peek());
           ans.set(i,h.get(s.pop()));
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(int i =0;i<ans.size();i++){
           if(ans.get(i) != -1){
           a.add(ans.get(i));
           }
        }
        return a;

    }
}