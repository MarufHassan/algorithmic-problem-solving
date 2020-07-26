class TimeMap {
    private Map<String, TreeMap<Integer, String>> maps;
    
    public TimeMap() {
        maps = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!maps.containsKey(key))
            maps.put(key, new TreeMap<>());
        maps.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!maps.containsKey(key))
            return "";
        TreeMap<Integer, String> m = maps.get(key);
        Integer t = m.floorKey(timestamp);
        return (t == null) ? "" : m.get(t);
    }
}