class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        while(true){
            boolean valid = false;
            for(int i=0;i<sb.length();i++){
                if(Character.isDigit(sb.charAt(i))){
                    int charIndex = i - 1 ;
                    while(charIndex >= 0){
                        if(Character.isLetter(sb.charAt(charIndex))){
                            sb.deleteCharAt(i);
                            sb.deleteCharAt(charIndex);
                            valid = true;
                            break;
                        }
                    }
                    break;
                }
            }
            if(valid == false)return sb.toString();
        }
        
    }
}
