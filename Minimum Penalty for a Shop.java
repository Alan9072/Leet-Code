class Solution {
    public int bestClosingTime(String customers) {
        int y = 0;
        int n = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                y++;
            }
        }

        int minPen = y;
        int minIndex = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                y--;
            }else{
                n++;
            }

            if(y + n < minPen){
                minPen = y + n;
                minIndex = i+1;
            }
        }
        return minIndex; 
    }
}
