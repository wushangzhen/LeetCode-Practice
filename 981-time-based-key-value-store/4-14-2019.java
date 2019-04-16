class TimeMap {

    /** Initialize your data structure here. */
    Map<Integer, String> timeToValue;
    Map<String, List<Integer>> keyToTime; 
    public TimeMap() {
        timeToValue = new HashMap<>();
        keyToTime = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyToTime.putIfAbsent(key, new ArrayList<>());
        keyToTime.get(key).add(timestamp);
        timeToValue.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!keyToTime.containsKey(key)) {
            return "";
        }
        List<Integer> times = keyToTime.get(key);
        if (times.size() == 0) {
            return "";
        } 
        int start = 0;
        int end = times.size() - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (times.get(mid) > timestamp) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (times.get(end) <= timestamp) {
            return timeToValue.get(times.get(end));
        } else if (times.get(start) <= timestamp) {
            return timeToValue.get(times.get(start));
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
