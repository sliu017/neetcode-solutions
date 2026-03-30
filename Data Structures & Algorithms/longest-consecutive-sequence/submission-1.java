class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> skipset = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        Arrays.sort(nums);
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            if(skipset.contains(x)){
                continue;
            }
            int j = x;
            int size = 1;
            while(set.contains(j+1)){
                skipset.add(j+1);
                j++;
                size++;
            }
            max = Math.max(size,max);

        }
        return max;

    }
}
