class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> skipset = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int max = 0;
        for(int x : set){
            if(set.contains(x-1)){
                continue;
            } else {
                int j = x;
                while(set.contains(j+1)){
                    j++;
                }
                max = Math.max(max,j-x+1);

            }
        }
        return max;

    }
}
