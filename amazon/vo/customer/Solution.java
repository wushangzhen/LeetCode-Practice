import java.util.*;
class Solution {
    public static String findOrders(String[][] input) {
        if (input == null || input.length == 0) {
            return "";
        }
        Arrays.sort(input, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                if (a[0].equals(b[0])) {
                    return a[2].compareTo(b[2]);
                } else {
                    return a[0].compareTo(b[0]);
                }
            }
        });
        String result = "";
        int max = Integer.MIN_VALUE;
        Map<String, Integer> memo = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = input.length;
        String res = "";
        while (right <= n) {
            while (right != n && input[right][0] == input[left][0] && right - left < 3) {
                res += input[right][1];
                right++;
            }
            if (right - left == 3) {
                memo.putIfAbsent(res, 0);
                memo.put(res, memo.get(res) + 1);
                if (memo.get(res) > max) {
                   max = memo.get(res); 
                   result = res;
                }
                res.substring(1);
                left++;
            } else if ((right == n || input[right][0] != input[left][0]) && right - left < 3) {
                left = right;
                res = "";
                right++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[][] input = {{"1", "A", "0"},
                            {"1", "B", "2"},
                            {"1", "C", "4"},
                            {"1", "D", "5"},
                            {"2", "A", "0"},
                            {"2", "B", "2"},
                            {"2", "C", "4"},
                            {"3", "A", "0"},
                            {"3", "D", "5"}
        };
        System.out.println(Solution.findOrders(input));
    }
}
