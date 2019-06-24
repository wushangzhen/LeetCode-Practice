class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // find the diagonal dist count == 2 and the others == 4
        List<int[]> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        long max = 0;
        long min = 0;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                long dist = getLength(list.get(i), list.get(j));
                if (max == dist) {
                    count++;
                } else if (max < dist) {
                    min = max;
                    max = dist;
                    count = 1;
                } else {
                    min = dist;
                }
            }
        }
        if (count != 2) {
            return false;
        }
        count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (min == getLength(list.get(i), list.get(j))) {
                    count++;
                }
            }
        }
        return count == 4;  
    }
    long getLength(int[] p1, int[] p2) {
        return ((long)p1[0] - p2[0]) * ((long)p1[0] - p2[0]) + ((long)p1[1] - p2[1]) * ((long)p1[1] - p2[1]);
    }
}
