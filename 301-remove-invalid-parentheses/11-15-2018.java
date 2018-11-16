class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(s);
        q.add(s);
        boolean found = false;
        while (!q.isEmpty()) {
            String str = q.poll();
            if (isValid(str)) {
                res.add(str);
                found = true;
            }
            if (found) {
                continue;
            } // this is to find the minimum
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                    continue;
                }
                String newStr = str.substring(0, i) + str.substring(i + 1);
                if (!visited.contains(newStr)) {
                    q.add(newStr);
                    visited.add(newStr);
                }
            }
        }
        return res;
    }
    boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (count < 0) {
                return false;
            }
            if (str.charAt(i) == '(') {
                count++;
            } else if (str.charAt(i) == ')') {
                count--;
            }
        }
        return count == 0;
    }
}
