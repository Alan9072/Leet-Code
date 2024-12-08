class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '*'){
                sb.deleteCharAt(sb.length() - 1);
            }else{
                sb.append(s.charAt(i));
            }
            
        }
        return sb.toString();
        // Stack<Character> stack = new Stack<>();
        // for(int i=0;i<s.length();i++){
        //     if(s.charAt(i) == '*'){
        //         stack.pop();
        //     }else{
        //         stack.push(s.charAt(i));
        //     }
        // }
        // StringBuilder sb = new StringBuilder();
        // while(!stack.isEmpty()){
        //     char letter = stack.pop();
        //     sb.append(letter);
        // }
        // return sb.reverse().toString();
    }
}
