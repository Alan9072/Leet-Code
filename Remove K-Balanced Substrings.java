class Pair{
    char ch;
    int cnt;
    Pair(char ch,int cnt){
        this.ch = ch;
        this.cnt = cnt;
    }
}
class Solution {
    public String removeSubstring(String s, int k) {
        Stack<Pair> stk = new Stack<>();

        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);

            if(stk.isEmpty()){
                Pair node = new Pair(curr,1);
                stk.push(node);
            }else{
                if(stk.peek().ch == curr){
                    Pair current = stk.peek();
                    current.cnt+= 1;
                }else{
                    Pair node = new Pair(curr,1);
                    stk.push(node);
                }

                ///remove part
                
                if(stk.size() >= 2){
                    Pair latest = stk.get(stk.size() - 1);
                    Pair prev = stk.get(stk.size() - 2);

                    if(latest.ch == ')' && prev.ch == '(' && Math.min(latest.cnt,prev.cnt) >= k){
                        latest = stk.pop();
                        prev = stk.pop();

                        latest.cnt -= k;
                        prev.cnt -= k;

                        if(prev.cnt > 0)stk.push(prev);
                        if(latest.cnt > 0)stk.push(latest);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<stk.size();i++){
            Pair curr = stk.get(i);
            char ch = curr.ch;
            while(curr.cnt > 0){
                sb.append(ch);
                curr.cnt -= 1;
            }
        }
        return sb.toString();
    }
}
