class Solution {
    public String[] divideString(String s, int k, char fill) {
        int num = k - (s.length() % k);
        StringBuilder sb = new StringBuilder(s);
        while (num > 0 && num != k) {
            sb.append(fill);
            num--;
        }
        int groups = sb.length() / k;
        return getIt(sb.toString(), groups, k);
    }

    public String[] getIt(String s, int groups, int k) {
        String[] result = new String[groups];
        int index = 0;
        for (int i = 0; i < s.length(); i += k) {
            String sub = s.substring(i, i + k);
            result[index] = sub;
            index++;
        }
        return result;
    }
}
