class CountSquares {
    HashMap<Integer, ArrayList<String>> xCoords;
    HashMap<String, Integer> all;
    public CountSquares() {
        xCoords = new HashMap<>();
        all = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        String co = x +"," +y;
        if (!all.containsKey(co)) {
            xCoords.putIfAbsent(x, new ArrayList<>());
            xCoords.get(x).add(co);
        }
        all.put(co, all.getOrDefault(co,0)+1);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        if(!xCoords.containsKey(x)){
            return 0;
        }
        int ans = 0;
        ArrayList<String> sameX = xCoords.get(x);
        for(String pt : sameX){
            int qt = all.get(pt);
            String[] parts = pt.split(",");
            int pty = Integer.parseInt(parts[1]);
            int dist = Math.abs(y - pty);
            if(dist == 0){
                continue;
            }
            ans += qt * all.getOrDefault(x+dist +"," +y, 0)
            * all.getOrDefault(x+dist + "," +pty, 0);
            
            ans += qt * all.getOrDefault(x-dist + "," +y, 0)
            * all.getOrDefault(x-dist +"," +pty, 0);

        }
        return ans;
    }
}
