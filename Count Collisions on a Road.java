class Solution {
    public int countCollisions(String directions) {
        int count = 0;
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<directions.length();i++){
            char curr = directions.charAt(i);
            if(stk.isEmpty() && curr == 'L'){
                continue;
            }else if(curr == 'R'){
                stk.push(curr);
            }else if(curr == 'L'){
                boolean crashed = false;
                while(!stk.isEmpty()){
                    if(stk.peek() == 'R'){
                        stk.pop();
                        count += crashed ? 1 : 2;
                        crashed = true;
                    }else if(stk.peek() == 'S'){
                        stk.pop();
                        count += crashed ? 0 : 1;//
                        break;
                    }
                }
                stk.push('S');
            }else if(curr == 'S'){
                while(!stk.isEmpty()){
                    if(stk.peek() == 'R'){
                        stk.pop();
                        count += 1;;
                    }else if(stk.peek() == 'S'){
                        break;
                    }
                }
                stk.push('S');
            }
        }
        return count;
    }
}
