import java.util.*;
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deque = new LinkedList<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!deque.isEmpty()) {
                deque.addFirst(deque.pollLast());
            }
            deque.addFirst(deck[i]);
        }
        int[] ans = new int[deque.size()];
        int n = deque.size();
        for (int i = 0; i < n; i++) {
            ans[i] = deque.pollFirst();
        }
        return ans;
    }
}
