class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        
        while (true) {
            int newNum = 0;
            while (n > 0) {
                int rem = n % 10;
                newNum += rem * rem;
                n = n / 10;
            }
            if (newNum == 1)
                return true;
            if (set.contains(newNum))
                return false;
            else {
                set.add(newNum);
            }
            n = newNum;
        }
    }
}
