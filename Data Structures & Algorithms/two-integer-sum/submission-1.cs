public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int,int> valueToIndex =  new Dictionary<int,int>();
        for (int i = 0; i < nums.Length; i++)
        {
            valueToIndex[nums[i]] = i;
        }

        for (int i = 0; i < nums.Length; i++)
        {
            if (valueToIndex.ContainsKey(target - nums[i]) && valueToIndex[target - nums[i]] != i)
            {
                return [i, valueToIndex[target - nums[i]]];
            }
        }
        return [0,0];
    }
}
