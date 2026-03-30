class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int min = 1;
        int max = 1;
        int ans = nums[0];
        for(int i = 0; i < n; i++){
            int tmp = max;
            max = Math.max(Math.max(nums[i], max * nums[i]),min * nums[i]);
            min = Math.min(Math.min(nums[i], min * nums[i]),tmp * nums[i]);
            ans = Math.max(ans,max);
        }
        return ans;
    }
}

/* initial idea for splitting into subproblems is to find a way
// to solve "the max product up to index i"
// dp[0] = a[0] ofc
// dp[1] = max(dp[0], a[0] * a[1])
// dp[2] = max(dp[1], dp[1] * a[2], ...
// try un multiplying a[0], e.g. examine a[1] * a[2]
MUST BE CONTIGUOUS SUBARRAY
should we check last value BEFORE a negative is reached?
alternatively count negatives?

-1 2 3 -4

dpPos: -1 2  6
dpNeg: -1 -2 -6

-1 -2 3 4 -2 3
could be largest product subarray with an even number of negative numbers
when we reach a negative number, 
multiplying by next element can ONLY increase its absolute value

maybe we can ALSO store largest NEGATIVE value (alternatively, minimal product)

*/