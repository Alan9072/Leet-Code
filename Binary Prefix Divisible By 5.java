class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();

        int num = nums[0];                 // keep your style
        if (num % 5 == 0) list.add(true);
        else list.add(false);

        for (int i = 1; i < nums.length; i++) {
            num = (2 * num + nums[i]) % 5; // <-- important fix (use % 5)
            
            if (num % 5 == 0) list.add(true);
            else list.add(false);
        }

        return list;
    }
}
