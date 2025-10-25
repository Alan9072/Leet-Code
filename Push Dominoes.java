class Solution {
    public String pushDominoes(String dominoes) {
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < dominoes.length(); i++) {
            char curr = dominoes.charAt(i);
            if (stk.isEmpty() || curr == '.') {
                stk.push(curr);
            } else if (curr == 'L') {
                int cnt = 0;
                while (!stk.isEmpty() && stk.peek() == '.') {
                    cnt++;
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    sb.append("L".repeat(cnt)).append('L');
                } else if (stk.peek() == 'L') {
                    stk.pop();
                    sb.append('L').append("L".repeat(cnt)).append('L');
                } else if (stk.peek() == 'R') {
                    stk.pop();
                    if(cnt % 2 == 0){
                        sb.append('R').append("R".repeat(cnt/2)).append("L".repeat(cnt/2)).append('L');
                    }else{
                        sb.append('R').append("R".repeat(cnt/2)).append('.').append("L".repeat(cnt/2)).append('L');
                    }
                }
            } else { // curr == 'R'
                int cnt = 0;
                while (!stk.isEmpty() && stk.peek() == '.') {
                    cnt++;
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    sb.append(".".repeat(cnt));
                    stk.push('R');
                } else if (stk.peek() == 'L') {
                    stk.pop();
                    sb.append('L').append(".".repeat(cnt));
                    stk.push('R');
                } else if (stk.peek() == 'R') {
                    stk.pop();
                    sb.append('R').append("R".repeat(cnt));
                    stk.push('R');
                }
            }
        }

        int val = 0;
        while(!stk.isEmpty() && stk.peek() == '.'){
            stk.pop();
            val++;
        }
        if(!stk.isEmpty() && stk.peek() == 'R'){
            sb.append("R".repeat(val)).append("R");
        }else if(!stk.isEmpty() && stk.peek() == 'L'){
            sb.append('L').append(".".repeat(val));
        }else{
            sb.append(".".repeat(val));
        }

        return sb.toString();
    }
}
