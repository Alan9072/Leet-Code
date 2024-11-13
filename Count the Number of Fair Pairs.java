import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums); 
        
        long countPairs = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            
            int left = i + 1;
            int right = nums.length - 1;
        
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int sum = nums[i] + nums[mid];
                
                if (sum < lower) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            int startRange = left; 
            
            left = i + 1;
            right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int sum = nums[i] + nums[mid];
                
                if (sum > upper) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            int endRange = right; 
            
            if (startRange <= endRange) {
                countPairs += (endRange - startRange + 1);
            }
        }
        
        return countPairs;
    }
}
