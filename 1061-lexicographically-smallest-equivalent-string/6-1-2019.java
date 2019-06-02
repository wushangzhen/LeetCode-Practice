class UnionFind {
    int[] father = new int[26];
    public UnionFind() {
        Arrays.fill(father, -1);
    }
    public int find(int x) {
        if (father[x] < 0) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) {
                father[b] = a;
            } else {
                father[a] = b;
            }
        }
    }
}

class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < A.length(); i++) {
            uf.union(A.charAt(i) - 'a', B.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            sb.append((char)(uf.find(c - 'a') + 'a'));
        }
        return sb.toString();
    }
}
