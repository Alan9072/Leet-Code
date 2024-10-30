class Solution {
    public String addBinary(String a, String b) {

        StringBuilder aword = new StringBuilder(a);
        StringBuilder bword = new StringBuilder(b);

        int alength = aword.length();
        int blength = bword.length();

        if (alength > blength) {
            int gap = alength - blength;
            while (bword.length() != aword.length()) {
                bword.insert(0, '0');
            }
        } else {
            int gap = blength - alength;
            while (aword.length() != bword.length()) {
                aword.insert(0, '0');
            }
        }

        StringBuilder sb = new StringBuilder();
        char carry = '0';
     
        for (int i = bword.length() - 1; i >= 0; i--) {
            if (aword.charAt(i) == '0' && bword.charAt(i) == '0') {
                if (carry == '1') {
                    sb.insert(0, '1');
                    carry = '0';
                } else {
                    sb.insert(0, '0');
                }
            }
            else if (aword.charAt(i) == '0' && bword.charAt(i) == '1') {
                if (carry == '1') {
                    sb.insert(0, '0');
                    carry = '1';
                } else {
                    sb.insert(0, '1');
                }
            }
            else if (aword.charAt(i) == '1' && bword.charAt(i) == '0') {
                if (carry == '1') {
                    sb.insert(0, '0');
                    carry = '1';
                } else {
                    sb.insert(0, '1');
                }
            }
            else if (aword.charAt(i) == '1' && bword.charAt(i) == '1') {
                if (carry == '1') {
                    sb.insert(0, '1');
                    carry = '1';
                } else {
                    sb.insert(0, '0');
                    carry = '1';
                }
            }

        }
        if(carry =='1'){
            sb.insert(0,'1');
        }

        return sb.toString();
    }
}
