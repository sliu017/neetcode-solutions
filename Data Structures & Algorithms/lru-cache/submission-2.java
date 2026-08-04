class LRUCache {
    private final Map<Integer,Integer> cache;
    private final int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true){
            // Params: capacity = max size of LinkedHashMap 
            // 0.75f = zoom factor, default is 0.75f
            // true = use **access** order, rather than insertion order
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return size() > LRUCache.this.capacity;
            }
        };
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
