class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> visited = new HashSet<>();
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        Queue<String> q = new LinkedList<>();
        q.add(s);
        visited.add(s);
        boolean flag = false;
        while (!q.isEmpty()) {
            String str = q.poll();
            if (isValid(str)) {
                res.add(str);
                flag = true;
            }
            if (flag) {
                continue;
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                    String sub = str.substring(0, i) + str.substring(i + 1);
                    if (!visited.contains(sub)) {
                        q.add(sub);
                        visited.add(sub);
                    }
                }
            }
        }
        return res;
    }
    boolean isValid(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
                if (right > left) {
                    return false;
                }
            }
        }
        return left == right;
    }
}
