class Solution {
    public String fractionAddition(String exp) {
        char[] arr = exp.toCharArray();
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> den = new ArrayList<>();

        for(int i =0;i<arr.length;){
            if(arr[i] == '/'){
                int no =0;
                i++;
                int p = 1;
                while(i<arr.length && arr[i]!= '-' && arr[i] != '+' ){
                    no = no*p+ (arr[i]-'0');
                   // System.out.println(no);
                    i++;
                    p = p*10;
                }
                den.add(no);
                continue;
            }
            else if(arr[i] == '-'){
                int no =0;
                i++;
                int p = 1;
                while(i<arr.length && arr[i]!= '/' ){
                    no = no*p+ (arr[i]-'0');
                    i++;
                    p = p*10;
                }
                
                num.add(no*-1);
                 continue;
            }
            else if(arr[i] == '+'){
                int no =0;
                i++;
                int p = 1;
                while(i<arr.length && arr[i]!= '/' ){
                    no = no*p+ (arr[i]-'0');
                    i++;
                    p = p*10;
                }
                num.add(no);
               continue;

            }
            else if(i ==0){
                int no =0;
                int p = 1;
                while(i<arr.length && arr[i]!= '/' ){
                    no = no*p+ (arr[i]-'0');
                    i++;
                    p = p*10;
                }
                num.add(no);
               // System.out.println(no);
            }
        }
        int lcm = lcm(den);
        int total=0;
    // System.out.println(den.size());
        for(int i =0;i<den.size();i++){
          
          total +=  lcm/den.get(i)*num.get(i);
        }
        int gcd = gcd(Math.abs(total),Math.abs(lcm));
          System.out.println(gcd);
        total = total/gcd;
        lcm = lcm/gcd;
        String n = String.valueOf(total);
        if(total == 0){
            return n+"/"+"1"; 
        }
        String d = String.valueOf(lcm);
        return n+"/"+d;
    }
    public int lcm(ArrayList<Integer> den ){
        int max =0;
        for(int i =0;i<den.size();i++){
            max = Math.max(den.get(i),max);
        }
        int n =1;
        while(true){
        int c=0;
        max = max*n;
        for(int i =0;i<den.size();i++){
           if(max% den.get(i) == 0 ){
            c++;
           }else{
            break;
           }
        }
        if(c == den.size()){
            return max;
        }
        n++;
        }
    }
    public int gcd(int a, int b){
        int gcd =1;
        for(int i = 2; i <= a && i <= b; i++)  
            {  
            if(a%i==0 && b%i==0) 
            gcd = i;  
            }  
   return gcd;
 }
}