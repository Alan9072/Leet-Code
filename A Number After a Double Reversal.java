class Solution {
    public boolean isSameAfterReversals(int num) {
        int org = num;
        int newNum = 0;
        int newNum2 = 0;
        while(num > 0){
            int rem = num % 10;
            newNum  = newNum * 10 + rem;
            num = num /10;
        }
         while(newNum > 0){
            int rem = newNum % 10;
            newNum2  = newNum2 * 10 + rem;
            newNum = newNum /10;
        }
       
        if(org == newNum2){return true;}
        return false;
    }
}
