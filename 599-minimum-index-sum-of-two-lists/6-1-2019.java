class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
             if (map.containsKey(list2[i])) {
                 map.put(list2[i], map.get(list2[i]) + i);
                 if (map.get(list2[i]) < min) {
                     min = map.get(list2[i]);
                     count = 1;
                     list.clear();
                     list.add(list2[i]);
                 } else if (map.get(list2[i]) == min) {
                     list.add(list2[i]);
                     count++;
                 }
             }
        }
        return list.toArray(new String[0]);
    }
}
