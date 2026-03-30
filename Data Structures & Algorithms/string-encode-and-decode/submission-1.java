class Solution {

    public String encode(List<String> strs) {
        String out = "";
        for(String s : strs){
            int len = s.length();
            out += len + "/" + s;
        }
        return out;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while(i < str.length()){
            int slash = str.indexOf('/', i);
            int x = Integer.valueOf(str.substring(i, slash));
            i = slash + 1;
            String cur = str.substring(i, i + x);
            list.add(cur);
            i += x;
        }
        return list;
    }
}