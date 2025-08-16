class Solution {
    public int maximum69Number (int num) {
        char[] arr = String.valueOf(num).toCharArray();

        StringBuilder result = new StringBuilder();
        boolean condition = false;
        for(char ch : arr){
            if(ch == '6' && condition == false){
                result.append('9');
                condition = true; 
                continue;
            }
            result.append(ch);
        }

        return Integer.parseInt(result.toString());
    }
}
