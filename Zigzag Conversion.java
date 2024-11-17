class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder("");
        int incr = numRows+(numRows - 2);
        for(int i=0;i<numRows;i++){
            
            for(int j=i;j<s.length();j=j+incr){
                sb.append(s.charAt(j));
                if(i != 0 && i != numRows - 1){
                    if((j + incr -2 * i) < s.length()){
                         sb.append(s.charAt(j + incr -2 * i));
                    }
                }
            }
        }
        return sb.toString();
        
    }
}
