class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        int left = 0;
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')'){
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        helper(left, right, s, res, new HashSet<>());
        return res;
    }
    void helper(int left, int right, String s, List<String> res, Set<String> set) {
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String str = q.poll();
                if (left == 0 && right == 0) {
                    if (isValid(str)) {
                        res.add(str);
                    }
                    continue;
                }
                for (int i = 0; i < str.length(); i++) {
                    if (left > 0) {
                        if (str.charAt(i) == '(') {
                            String temp = str.substring(0, i) + str.substring(i + 1);
                            if (!set.contains(temp)) {
                                q.add(temp);
                                set.add(temp);
                            }
                        }
                    } else if (right > 0) {
                        if (str.charAt(i) == ')') {
                            String temp = str.substring(0, i) + str.substring(i + 1);
                            if (!set.contains(temp)) {
                                q.add(temp);
                                set.add(temp);
                            }
                        }
                    }
                }  
            }
            if (left > 0) {
                left--;
            } else if (right > 0) {
                right--;
            }
        }
    }
    boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')'){
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return left == 0 && right == 0;
    }
}
