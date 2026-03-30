class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,Integer> map = new HashMap(); // we can use the outer hashmap to index
        int index = 0;
        List<List<String>> list = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            // deconstruct the string
            HashMap<Character,Integer> cur = new HashMap<>();
            for(int j = 0; j < strs[i].length(); j++){
                char c = strs[i].charAt(j);
                cur.put(c,cur.getOrDefault(c,0)+1);
            }
            if(map.containsKey(cur)){
                int ind = map.get(cur);
                list.get(ind).add(strs[i]);
            } else {
                ArrayList<String>toAdd = new ArrayList<>();
                toAdd.add(strs[i]);
                list.add(toAdd);
                map.put(cur,index++);
            }

        }
        return list;

    }
}
