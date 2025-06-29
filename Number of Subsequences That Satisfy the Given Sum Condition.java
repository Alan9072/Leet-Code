public class Solution 
{
    public int numSubseq(int[] nums, int target) 
    {
        final int MOD = 1_000_000_007;
        int n = nums.length;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Precompute powers of 2 up to n
        int[] powers = new int[n];
        powers[0] = 1;
        for (int i = 1; i < n; i++) 
        {
            powers[i] = (powers[i - 1] * 2) % MOD;
        }

        // Step 3: Initialize two pointers
        int left = 0;
        int right = n - 1;
        int result = 0;

        // Step 4: Two-pointer approach to count valid subsequences
        while (left <= right) 
        {
            if (nums[left] + nums[right] <= target) 
            {
                // Step 4.1: All subsets between left and right are valid
                result = (result + powers[right - left]) % MOD;
                left++;
            } 
            else 
            {
                // Step 4.2: Try smaller max if condition fails
                right--;
            }
        }

        // Step 5: Return the result modulo 10^9 + 7
        return result;
    }
}
