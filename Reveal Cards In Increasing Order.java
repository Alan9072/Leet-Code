import java.util.*;
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] result = new int[deck.length];
        Deque<Integer> dq = new LinkedList<>();
        Arrays.sort(deck);

        int idx = deck.length - 1;
        while(idx >= 0){
            rotate(dq);
            dq.addFirst(deck[idx]);
            idx--;
        }

        idx = 0;
        while(!dq.isEmpty()){
            int curr = dq.removeFirst();
            result[idx++] = curr;
        }
        return result;
    }
    public void rotate(Deque<Integer> dq){
        if(dq.isEmpty()) return;

        int tail = dq.removeLast();
        dq.addFirst(tail);
    }
}
