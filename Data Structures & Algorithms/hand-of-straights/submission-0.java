class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> have = new HashMap<>();
        int n = hand.length;
        for(int i = 0; i < n; i++){
            int x = hand[i];
            have.put(x, have.getOrDefault(x, 0)+1);
        }
        Arrays.sort(hand);
        for(int i = 0; i < n; i++){
            if(have.containsKey(hand[i])){
                for(int j = 0; j < groupSize; j++){
                    if(!have.containsKey(hand[i] + j)){
                        return false;
                    } else {
                        remove(have, hand[i] + j);
                    }
                }
            } else {
                continue;
            }
        }
        return true;
    }
    public void remove(HashMap<Integer,Integer> hand, int card){
        hand.put(card, hand.get(card)-1);
        if(hand.get(card) == 0){
            hand.remove(card);
        }
    }
}
