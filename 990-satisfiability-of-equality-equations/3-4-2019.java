class UnionFind {
    int[] father;
    public UnionFind(int n) {
        father = new int[n];
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
            father[a] = b;
        }
    }
}


class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int a = str.charAt(0) - 'a';
                int b = str.charAt(3) - 'a';
                uf.union(a, b);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int a = str.charAt(0) - 'a';
                int b = str.charAt(3) - 'a';
                if (uf.find(a) == uf.find(b)) {
                    return false;
                }
            }
        }
        return true;
    }
}
