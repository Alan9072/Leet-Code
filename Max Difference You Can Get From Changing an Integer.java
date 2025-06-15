class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        String t = String.valueOf(num);

        //max value
        int index = 0;
        while (index < s.length() && s.charAt(index) == '9') {
            index++;
        }
        int max = 0;
        if (index != s.length()) {
            s = s.replace(s.charAt(index), '9');
        }
        max = Integer.parseInt(s);

        //min value
        index = 0;
        int min = 0;
        if (t.charAt(index) == '1') {
            while (index < t.length() && (t.charAt(index) == '0' || t.charAt(index) == '1')) {
                index++;
            }
            System.out.println(index);
            if (index != t.length()) {
                t = t.replace(t.charAt(index), '0');
            }
        } else {
            t = t.replace(t.charAt(index), '1');
        }
        min = Integer.parseInt(t);
        return max - min;
    }
}
