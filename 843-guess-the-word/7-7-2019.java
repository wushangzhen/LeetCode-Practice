/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
import javafx.util.Pair;
class Solution {
    public int match(String s1, String s2) {
        int match = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                match++;
            }
        }
        return match;
    }
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            Map<String, Integer> count = new HashMap<>();
            for (String w1 : wordlist) {
                for (String w2: wordlist) {
                    if (match(w1, w2) == 0) {
                        count.put(w1, count.getOrDefault(w1, 0) + 1);
                    }
                }
            }
            Pair<String, Integer> minimax = new Pair<>("", 1000);
            for (String w : wordlist) {
                if (count.getOrDefault(w, 0) < minimax.getValue()) {
                    minimax = new Pair<>(w, count.getOrDefault(w, 0));
                }
            }
            x = master.guess(minimax.getKey());
            List<String> wordlist2 = new ArrayList<>();
            for (String w : wordlist) {
                if (match(minimax.getKey(), w) == x) {
                    wordlist2.add(w);
                }
            }
            wordlist = wordlist2.toArray(new String[0]);
        }
    }
}
