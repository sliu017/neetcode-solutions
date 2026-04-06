class TimeMap {
    private HashMap<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).put(timestamp,value);
        } else {
            TreeMap<Integer,String> tree = new TreeMap<>();
            tree.put(timestamp,value);
            map.put(key,tree);
        }

    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            if(map.get(key).floorKey(timestamp) != null){
                return map.get(key).get(map.get(key).floorKey(timestamp));
            } else {
                return "";
            }
        } else {
            return "";
        }
    }
}
