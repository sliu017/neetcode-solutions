class Solution {
        public int[] topKFrequent(int[] nums, int k){
        int n = nums.length;
        HashMap<Integer,Integer> freq = new HashMap<>();
        HashSet<Integer>[] freqct = new HashSet[n+1];
        int maxfreq = 0;
        for(int i = 0; i < n+1; i++){
            freqct[i] = new HashSet<>();
        }
        for(int i = 0; i < nums.length; i++){
            int e = nums[i];
            freq.put(e,freq.getOrDefault(e,0)+1);
            int ct = freq.get(e);
            maxfreq = Math.max(ct,maxfreq);
            if (ct > 1){
                freqct[ct-1].remove(e);
            }
            freqct[ct].add(e);
        }
        int[] out = new int[k];
        int i = 0;
        while(i < k){
            for(int e : freqct[maxfreq]){
                out[i++] = e;
            }
            maxfreq--;
        }
        return out;
    }
}
