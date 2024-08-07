class Solution {
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        String v[] = {"Hundred ","Thousand ","Million ","Billion "};
        String n[] = {"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};
        String t[] = {"","Ten ","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
        String one[] = {"Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ", "Fifteen ","Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        Stack<Integer> s = new Stack<>();
        int c=0;
        while(num!=0){
            int a = num%10;
            s.push(a);
            num = num/10;
            c++;
        }
        int cnt = c-1;
        String ans = "";
        int zero=0;
        while(!s.isEmpty()){
            int curr = s.pop();
            if(curr == 0){
                zero++;
            }
            else{
                zero =0;
            }
            if(zero >=3){
                cnt--;
                continue;
            }
            if(cnt % 3 == 0){
                ans += n[curr];
                if(cnt != 0 ){
                    ans += v[cnt/3] ;
                }
            } 
            else if((cnt+1) % 3 == 0 && curr != 0){
                ans += n[curr] + v[0];
            }
            else if((cnt-1) % 3 == 0 ){
                if(curr == 1){
                    // if(s.isEmpty()){
                    //     ans+= "Ten";
                    //     break;
                    // }
                    int next = s.pop();
                    if(cnt -1 == 0){
                        ans+= one[next];
                    }else {
                    ans+=one[next]+v[(cnt-1)/3];
                    }
                    cnt--;
                }else{
                    ans+=t[curr];
                }
            }
            cnt--;
        }
        return ans.trim();
    }
}