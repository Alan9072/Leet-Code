class Solution {
    public boolean checkPowersOfThree(int n) {
        HashSet<Integer> set = new HashSet<>();
        return isValid(n,set);
    }
    public boolean isValid(int n,HashSet<Integer> set){
        

        int total = 0;
        int newVal = 0;
        int power = -1;
        int i = 0;
        while(total <= n){
            newVal = total;
            power = i;
            int val = (int) Math.pow(3,i);
            total = val;
            i++;
        }

        if(set.contains(power))return false;
        else{
            set.add(power);
        }

        if(n == newVal) return true;

        return isValid(n - newVal,set);
    }
}
