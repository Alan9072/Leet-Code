class Solution {
    public boolean rotateString(String s, String goal) {
      
        if(s.length()!=goal.length()){
            return false;
        }

        String str=s+s;

        if(str.contains(goal)){
            return true;
        }

        return false;
    
        // if(s.length() != goal.length())return false;
        
        // StringBuilder string = new StringBuilder(s);
        
        // boolean matches = false;
        // for(int i=0;i<s.length();i++){
        //     char last = string.charAt(string.length() - 1);
        //     string.insert(0,last);
        //     string.delete(string.length() - 1,string.length());

        //     if(string.toString().equals(goal)){
        //         return true;
        //     }
        // }
        // return matches;
    }
}
