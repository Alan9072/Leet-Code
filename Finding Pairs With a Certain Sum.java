class FindSumPairs {
    int[] arr2;
    Map<Integer, Integer> freq1;
    Map<Integer, Integer> freq2;
    
    public FindSumPairs(int[] nums1, int[] nums2) {
        freq1 = new HashMap<>();
        freq2 = new HashMap<>();
        
        for (int num : nums1) {
            freq1.put(num, freq1.getOrDefault(num, 0) + 1);
        }
        
        arr2 = nums2;
        for (int num : nums2) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int oldVal = arr2[index];
        freq2.put(oldVal, freq2.get(oldVal) - 1);
        if (freq2.get(oldVal) == 0) freq2.remove(oldVal);
        
        arr2[index] += val;
        int newVal = arr2[index];
        freq2.put(newVal, freq2.getOrDefault(newVal, 0) + 1);
    }
    
    public int count(int tot) {
        int count = 0;
        for (int num1 : freq1.keySet()) {
            int target = tot - num1;
            count += freq1.get(num1) * freq2.getOrDefault(target, 0);
        }
        return count;
    }
}
