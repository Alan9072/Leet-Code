class Solution {
    public int compress(char[] chars) {
        int pos = 0;
        for(int i=0;i<chars.length;i++){
            int count = 0;
            char curr = chars[i];

            while(i < chars.length && chars[i] == curr ){
                count++;
                i++;
            }
 
            if(count > 1 && count < 10){
                chars[pos] = curr;
                pos++;
                chars[pos] = Character.forDigit(count, 10);
                pos++;
            }else if(count >= 10){
                String numberStr = Integer.toString(count);
                char[] digits = numberStr.toCharArray();
                chars[pos] = curr;
                pos++;
                for(char val:digits){
                    chars[pos] = val;
                    pos++;
                }
            }else {
                chars[pos] = curr;
                pos++;
            }
            i = i-1;
        }
        return pos;
    }
}
