class Solution {
    public String robotWithString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        Stack<Character> stk = new Stack<>();
        int index = 0;

        for (int i = 0; i < 26; i++) {
            if (arr[i] <= 0)
                continue;
            else {
                char curr = (char) ('a' + i);
                while (!stk.isEmpty() && stk.peek() <= curr) {
                    char fromStk = stk.pop();
                    sb.append(fromStk);
                }

                while (arr[i] > 0) {
                    char currCh = s.charAt(index);
                    if (currCh == curr) {
                        while (!stk.isEmpty() && stk.peek() < currCh) {
                            char fromStk = stk.pop();
                            sb.append(fromStk);
                        }
                        sb.append(currCh);

                    } else {
                        stk.push(currCh);

                    }
                    arr[currCh - 'a']--;
                    index++;
                }
            }
        }
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        return sb.toString();

    }
}
