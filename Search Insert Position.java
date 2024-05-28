class Solution {
    public int searchInsert(int[] nums, int target) {
        int pos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                pos = i;
                break;
            }

        }
        if (pos >= 0)
            return pos;
        else {
            for (int i = 0; i < nums.length; i++) {
                if (target > nums[i]) {
                    if (target > nums[nums.length - 1]) {

                        pos = nums.length;

                        break;
                    }
                } else {
                    pos = i;
                    break;
                }
            }
            return pos;

        }

    }
}
