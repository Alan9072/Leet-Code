class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> list = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                list.push(list.pop() + list.pop());
            }
            else if(tokens[i].equals("-")){
                int a = list.pop();
                int b = list.pop();
                list.push(b - a);
            }
            else if(tokens[i].equals("*")){
                list.push(list.pop() * list.pop());
            }
            else if(tokens[i].equals("/")){
                int a = list.pop();
                int b = list.pop();
                list.push(b/a);
            }
            else{
                list.push(Integer.valueOf(tokens[i]));
            }
        }
        return list.peek();
    }
}
