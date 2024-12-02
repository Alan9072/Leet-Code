class Solution {
    public String decodeString(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder mainResult = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr == ']'){
                StringBuilder letters = new StringBuilder();
                while(stk.peek()!= '['){
                    letters.insert(0,stk.pop());
                }
                stk.pop();//remove the remaining '['
                StringBuilder number = new StringBuilder();
                while(!stk.isEmpty() && Character.isDigit(stk.peek())){
                    number.insert(0,stk.pop());
                }
                StringBuilder result = new StringBuilder();
                for(int j=0;j<Integer.parseInt(number.toString());j++){
                    result.append(letters.toString());
                }
                for(int j=0;j<result.length();j++){
                    stk.push(result.charAt(j));
                }

            }else{
                stk.push(curr);
            } 
        }
        
        while(!stk.isEmpty()){
            mainResult.insert(0,stk.pop());
        }
        return mainResult.toString();
    }
}
