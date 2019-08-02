class Solution {
    public double minAreaFreeRect(int[][] points) {
        Map<String, Map<Double, List<int[]>>> map = new HashMap<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double centerX = ((double)points[i][0] + points[j][0]) / 2;
                double centerY = ((double)points[i][1] + points[j][1]) / 2;
                double dist = ((double)points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                String str = centerX + " " + centerY;
                map.putIfAbsent(str, new HashMap<>());
                map.get(str).putIfAbsent(dist, new ArrayList<>());
                map.get(str).get(dist).add(points[i]); 
                map.get(str).get(dist).add(points[j]);
            }
        }
        double min = Double.MAX_VALUE;
        for (String c : map.keySet()) {
            for (double d : map.get(c).keySet()) {
                List<int[]> list = map.get(c).get(d);
                if (list.size() >= 4) {
                    for (int i = 0; i + 2 < list.size(); i += 2) {
                        for (int j = i + 2; j + 1 < list.size(); j += 2) {
                            double dist1 = Math.sqrt(((double)list.get(i)[0] - list.get(j)[0]) * ((double)list.get(i)[0] - list.get(j)[0]) + ((double)list.get(i)[1] - list.get(j)[1]) * ((double)list.get(i)[1] - list.get(j)[1]));
                            double dist2 = Math.sqrt(((double)list.get(i)[0] - list.get(j + 1)[0]) * ((double)list.get(i)[0] - list.get(j + 1)[0]) + ((double)list.get(i)[1] - list.get(j + 1)[1]) * ((double)list.get(i)[1] - list.get(j + 1)[1]));
                            min = Math.min(dist1 * dist2, min);
                        }
                    }
                }
            }
        }
        return min == Double.MAX_VALUE ? 0 : min;
    }
}
