class Solution {
    public int romanToInt(String s) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                arr.add(1);
            }
            if (s.charAt(i) == 'V') {
                arr.add(5);
            }
            if (s.charAt(i) == 'X') {
                arr.add(10);
            }
            if (s.charAt(i) == 'L') {
                arr.add(50);
            }
            if (s.charAt(i) == 'C') {
                arr.add(100);
            }
            if (s.charAt(i) == 'D') {
                arr.add(500);
            }
            if (s.charAt(i) == 'M') {
                arr.add(1000);
            }

        }
        int sum = 0;
        int i=0;
        while( i <= arr.size() - 1) {
            if (i == arr.size() - 1) {
                sum = sum + arr.get(i);
            } else {
                if (arr.get(i) >= arr.get(i + 1)) {
                    sum = sum + arr.get(i);
                } else {
                     if (i == arr.size() - 1) {
                         sum = sum + arr.get(i);
                    }else{
                     sum = sum + arr.get(i + 1) - arr.get(i);
                     i++;
                }
            }
        }
       
    i++;
    }
     return sum;

}
}
