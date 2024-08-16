class Solution {
    public boolean lemonadeChange(int[] bills) {
        long five = 0;
        long ten =0;
        for(int i =0;i<bills.length;i++){
            if(bills[i] == 5){
                five++;
            }
            else if(bills[i] == 10){
                if(five == 0){
                   // System.out.println("ten");
                    return false;
                }
                five--;
                ten++;
            }
            else if(bills[i] == 20){
                if(five >= 3 ||(five>= 1 && ten >= 1)){
                if(five>= 1 && ten >= 1){
                    ten--;
                    five--;
                    //continue;
                }
                else if(five >= 3){
                    five-= 3;
                   // continue;
                }
                
                }
                else{
                   // System.out.println(i);
                    return false;
                }
            }
        }
        return true;
    }
}