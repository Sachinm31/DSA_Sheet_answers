package Greedy;
//Input: bills = [5,5,5,10,20]
//        Output: true
//        Explanation:
//        From the first 3 customers, we collect three $5 bills in order.
//        From the fourth customer, we collect a $10 bill and give back a $5.
//        From the fifth customer, we give a $10 bill and a $5 bill.
//        Since all customers got correct change, we output true.
public class LemonadeChange {
    public static boolean lemonadechange(int bills[]){
        int five = 0;
        int ten = 0;

        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            if(bills[i]==10){
                if(five>0){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }
            if(bills[i]==20){
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }
                else if(five>=3){
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int bills[] = {5,5,5,10,20};
        System.out.println(lemonadechange(bills));
        lemonadechange(bills);
    }
}
